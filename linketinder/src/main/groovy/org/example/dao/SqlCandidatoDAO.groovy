package org.example.dao

import groovy.sql.Sql
import org.example.model.Candidato
import org.example.model.Curtida
import org.example.model.Vaga

class SqlCandidatoDAO implements CandidatoDAO{

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )
    @Override
    List<Candidato> getAllCandidatos() {
        sql.rows("SELECT * FROM dados_candidatos").collect({ row ->
            Candidato candidato = new Candidato()
            candidato.setId(row.id_candidato)
            candidato.setNome(row.nome)
            candidato.setSobrenome(row.sobrenome)
            candidato.setDataDeNascimento(row.data_de_nascimento.toString())
            candidato.setEmail(row.email)
            candidato.setCpf(row.cpf)
            candidato.setPais(row.pais)
            candidato.setCep(row.cep)
            candidato.setDescricao(row.descricao)
            candidato.setSenha(row.senha)
            candidato.setCompetencias(sql.rows("""
                SELECT c.competencia
                FROM competencias c
                JOIN candidatos_competencias cc
                    ON c.id_competencia = cc.id_competencia
                WHERE cc.id_candidato = ?
            """, [row.id_candidato]).collect { it.competencia })

            candidato
        })
    }

    @Override
    Candidato findCandidatoById(int id) {

        def row = sql.firstRow("""
        SELECT *
        FROM dados_candidatos
        WHERE id_candidato = ?
    """, id)

        Candidato candidato = new Candidato()

        candidato.setId(row.id_candidato)
        candidato.setNome(row.nome)
        candidato.setSobrenome(row.sobrenome)
        candidato.setDataDeNascimento(row.data_de_nascimento.toString())
        candidato.setEmail(row.email)
        candidato.setCpf(row.cpf)
        candidato.setPais(row.pais)
        candidato.setCep(row.cep)
        candidato.setDescricao(row.descricao)
        candidato.setSenha(row.senha)
        candidato.setCompetencias(sql.rows("""
                SELECT c.competencia
                FROM competencias c
                JOIN candidatos_competencias cc
                    ON c.id_competencia = cc.id_competencia
                WHERE cc.id_candidato = ?
            """, [row.id_candidato]).collect { it.competencia })


        candidato
    }

    @Override
    void insertCandidato(Candidato candidato) {

        def params = [
                candidato.getNome(),
                candidato.getSobrenome(),
                java.sql.Date.valueOf(candidato.getDataDeNascimento()),
                candidato.getEmail(),
                candidato.getCpf(),
                candidato.getPais(),
                candidato.getCep(),
                candidato.getDescricao(),
                candidato.getSenha()
        ]

        def row = sql.firstRow("""
        INSERT INTO dados_candidatos (
            nome,
            sobrenome,
            data_de_nascimento,
            email,
            cpf,
            pais,
            cep,
            descricao,
            senha
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        RETURNING id_candidato
    """, params)

        candidato.setId(row.id_candidato)
    }


    @Override
    void deleteCandidato(int id) {
        sql.execute("DELETE FROM dados_candidatos WHERE id_candidato=?",id)
    }

    void updateCandidato(Candidato candidato) {
        def params = [
                candidato.getNome(),
                candidato.getSobrenome(),
                candidato.getDataDeNascimento(),
                candidato.getEmail(),
                candidato.getCpf(),
                candidato.getPais(),
                candidato.getCep(),
                candidato.getDescricao(),
                candidato.getSenha(),
                candidato.getId()
        ]

        sql.execute("""
        UPDATE dados_candidatos
        SET nome = ?,
            sobrenome = ?,
            data_de_nascimento = ?,
            email = ?,
            cpf = ?,
            pais = ?,
            cep = ?,
            descricao = ?,
            senha = ?
        WHERE id_candidato = ?
    """, params)
    }

    @Override
    void salvarCurtidaDoCandidato(Candidato candidato, Vaga vaga,CurtidaDAO curtidaDB){
        if(curtidaDB.candidatoAlreadyLikedEmpresa(candidato.id,vaga.idEmpresa)) return
        if(curtidaDB.empresaAlreadyLikedCandidato(candidato.id,vaga.idEmpresa)){
            Curtida curtida = curtidaDB.getCurtidaObject(candidato.id,vaga.idEmpresa)
            curtida.candidato_curtiu = true
            curtidaDB.updateCurtida(curtida)
            return
        }
        curtidaDB.insertCurtida(candidato.id,vaga.idEmpresa,true,false)
    }

    @Override
    void salvarCompetenciasDoCandidatoNoBD(Candidato candidato,CompetenciaDAO competenciaDB) {
        List <String> listaCompetenciasStr = candidato.competencias
        SqlCandidatoCompetenciaDAO sqlCandidatoCompetenciaDAO = new SqlCandidatoCompetenciaDAO()
        listaCompetenciasStr.forEach { it ->
            sqlCandidatoCompetenciaDAO.insert(
                    candidato.id,
                    competenciaDB.findCompetenciaId(it)
            )
        }
    }

    @Override
    int getIdAntesDeSalvarNoBd() {
        sql.firstRow("""
        SELECT nextval(
            pg_get_serial_sequence('dados_candidatos', 'id_candidato')
        ) AS id
    """).id
    }
}

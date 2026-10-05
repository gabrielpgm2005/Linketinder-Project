package org.example.dao

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.example.model.Candidato

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

}

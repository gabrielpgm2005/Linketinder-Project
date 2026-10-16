package org.example.dao

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.example.model.Vaga

class SqlVagaDAO implements VagaDAO{
    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )
    @Override

    List<Vaga> getAllVagas() {
        sql.rows("SELECT * FROM dados_vagas").collect({ row ->
            Vaga vaga = new Vaga()
            vaga.setId(row.id_vaga)
            vaga.setNome(row.nome)
            vaga.setIdEmpresa(row.id_empresa)
            vaga.setDescricao(row.descricao)
            vaga.setLocal(row.local)
            vaga.setCompetencias(sql.rows("""
                SELECT c.competencia
                FROM competencias c
                JOIN vagas_competencias vc
                    ON c.id_competencia = vc.id_competencia
                WHERE vc.id_vaga = ?
            """, [row.id_vaga]).collect { it.competencia })

            vaga
        })
    }

    @Override
    Vaga findVagaById(int id) {
        GroovyRowResult row = sql.firstRow("SELECT * FROM dados_vagas WHERE id_vaga=?",id)
        Vaga vaga = new Vaga()
        vaga.setId(row.id_vaga)
        vaga.setIdEmpresa(row.id_empresa)
        vaga.setDescricao(row.descricao)
        vaga.setLocal(row.local)
        vaga
    }

    @Override
    void insertVaga(Vaga vaga) {
        def params = [
                vaga.getIdEmpresa(),
                vaga.getNome(),
                vaga.getDescricao(),
                vaga.getLocal()
        ]

        def row = sql.firstRow("""
        INSERT INTO dados_vagas
        (id_empresa, nome, descricao, local)
        VALUES (?, ?, ?, ?)
        RETURNING id_vaga
    """, params)

        vaga.setId(row.id_vaga)
    }

    @Override
    void deleteVaga(int id) {
        sql.execute("DELETE FROM dados_vagas WHERE id_vaga=?",id)
    }

    void updateVaga(Vaga vaga){
        def params = [
                vaga.getIdEmpresa(),
                vaga.getNome(),
                vaga.getDescricao(),
                vaga.getLocal(),
                vaga.getId()
        ]
        sql.execute("""
        UPDATE dados_vagas 
        SET 
            id_empresa=?,
            nome=?,
            descricao=?,
            local=?
        WHERE id_vaga=?
        
        """,params)
    }

    @Override
    void salvarCompetenciasDaVagaNoBD(Vaga vaga,CompetenciaDAO competenciaDB) {
        List <String> listaCompetenciasStr = vaga.competencias
        SqlVagaCompetenciaDAO sqlVagaCompetenciaDAO = new SqlVagaCompetenciaDAO()
        listaCompetenciasStr.forEach { it ->
            sqlVagaCompetenciaDAO.insert(
                    vaga.id,
                    competenciaDB.findCompetenciaId(it)
            )
        }
    }

    @Override
    int getIdAntesDeSalvarNoBd() {
        sql.firstRow("""
        SELECT nextval(
            pg_get_serial_sequence('dados_vagas', 'id_vaga')
        ) AS id
    """).id
    }
}

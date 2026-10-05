package org.example.dao

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.example.model.Candidato
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
            vaga.setIdEmpresa(row.id_empresa)
            vaga.setDescricao(row.descricao)
            vaga.setLocal(row.local)
            vaga
        })
    }

    @Override
    Vaga findVagaById(int id) {
        GroovyRowResult row = sql.firstRow("SELECT * FROM dados_vagas WHERE id_vaga=?",id)
        Vaga vaga = new Vaga()
        vaga.setId(row.id_vaga)
        vaga.setEmpresa(row.id_empresa)
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
                vaga.getEmpresa(),
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
}

package org.example.dao


import groovy.sql.Sql

class SqlVagaCompetenciaDAO {

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )

    void insert(int idVaga, int idCompetencia) {
        sql.execute("""
            INSERT INTO vagas_competencias
            (id_vaga, id_competencia)
            VALUES (?, ?)
        """, [idVaga, idCompetencia])
    }
}
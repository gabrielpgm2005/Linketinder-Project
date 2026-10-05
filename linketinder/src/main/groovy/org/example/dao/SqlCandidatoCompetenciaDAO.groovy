package org.example.dao

import groovy.sql.Sql

class SqlCandidatoCompetenciaDAO {

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )

    void insert(int idCandidato, int idCompetencia) {
        sql.execute("""
            INSERT INTO candidatos_competencias
            (id_candidato, id_competencia)
            VALUES (?, ?)
        """, [idCandidato, idCompetencia])
    }
}
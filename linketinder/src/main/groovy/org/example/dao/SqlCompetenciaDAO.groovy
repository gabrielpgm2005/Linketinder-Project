package org.example.dao

import groovy.sql.Sql
import org.example.model.Competencia

class SqlCompetenciaDAO implements CompetenciaDAO{

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )

    @Override
    List<Competencia> getAllCompetencias() {
        sql.rows("SELECT * FROM public.competencias").collect({ row ->
            Competencia competencia = new Competencia()
            competencia.setId(row.id_competencia)
            competencia.setCompetencia(row.competencia)
            competencia
        })
    }

    @Override
    Competencia findCompetenciaById(int id) {
        def row = sql.firstRow("SELECT * FROM competencias WHERE id_competencia=?",id)
        Competencia competencia = new Competencia()
        competencia.setId(row.id_competencia)
        competencia.setCompetencia(row.competencia)
        competencia
    }

    @Override
    void insertCompetencia(Competencia competencia) {
        def params = [
                competencia.getCompetencia()
        ]
        sql.execute("""
            INSERT INTO competencias (competencia)
            VALUES (?)
            ON CONFLICT (competencia) DO NOTHING
        """,params)
    }

    @Override
    void deleteCompetencia(int id) {
        sql.execute("DELETE FROM competencias WHERE id_competencia =?",id)

    }

    @Override
    void updateCompetencia(Competencia competencia) {
        def params = [
                competencia.getCompetencia(),
                competencia.getId()
        ]
        sql.execute("""
            UPDATE competencias
            SET competencia = ?
            WHERE id_competencia=?
    """,params)
    }

    @Override
    int findCompetenciaId(String competencia) {
        def row = sql.firstRow(
                "SELECT id_competencia FROM competencias WHERE competencia = ?",
                competencia
        )

        return row.id_competencia
    }


}

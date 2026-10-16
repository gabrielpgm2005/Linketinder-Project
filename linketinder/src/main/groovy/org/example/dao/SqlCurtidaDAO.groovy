package org.example.dao

import groovy.sql.Sql
import org.example.model.Curtida

class SqlCurtidaDAO implements CurtidaDAO {

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )

    @Override
    List<Curtida> getAllCurtidas() {
        sql.rows("SELECT * FROM status_match").collect { row ->

            Curtida curtida = new Curtida()

            curtida.setId(row.id_status_match)
            curtida.setIdEmpresa(row.id_empresa)
            curtida.setIdCandidato(row.id_candidato)
            curtida.setCandidato_curtiu(row.candidato_curtiu)
            curtida.setEmpresa_curtiu(row.empresa_curtiu)

            curtida
        }
    }

    @Override
    Curtida findCurtidaById(int id) {

        def row = sql.firstRow("""
            SELECT *
            FROM status_match
            WHERE id_status_match = ?
        """, id)

        Curtida curtida = new Curtida()

        curtida.setId(row.id_status_match)
        curtida.setIdEmpresa(row.id_empresa)
        curtida.setIdCandidato(row.id_candidato)
        curtida.setCandidato_curtiu(row.candidato_curtiu)
        curtida.setEmpresa_curtiu(row.empresa_curtiu)

        curtida
    }


    @Override
    void insertCurtida(int candidatoId, int empresaId,boolean candidatoCurtiu,boolean empresaCurtiu) {

        def params = [
                empresaId,
                candidatoId,
                empresaCurtiu,
                candidatoCurtiu
        ]

        sql.execute("""
            INSERT INTO status_match (
                id_empresa,
                id_candidato,
                empresa_curtiu,
                candidato_curtiu
            )
            VALUES (?, ?, ?, ?)
        """, params)
    }

    @Override
    void deleteCurtida(int id) {

        sql.execute("""
            DELETE FROM status_match
            WHERE id_status_match = ?
        """, id)
    }

    @Override
    void updateCurtida(Curtida curtida) {

        def params = [
                curtida.getIdEmpresa(),
                curtida.getIdCandidato(),
                curtida.getEmpresa_curtiu(),
                curtida.getCandidato_curtiu(),
                curtida.getId()
        ]

        sql.execute("""
            UPDATE status_match
            SET id_empresa = ?,
                id_candidato = ?,
                empresa_curtiu = ?,
                candidato_curtiu = ?
            WHERE id_status_match= ?
        """, params)
    }


    @Override
    boolean candidatoAlreadyLikedEmpresa(int candidatoId,int empresaId) {

        def row = sql.firstRow("""
            SELECT EXISTS (
                SELECT 1
                FROM status_match
                WHERE id_empresa = ?
                  AND id_candidato = ?
                  AND candidato_curtiu = TRUE
            )
        """, [empresaId, candidatoId])

        row[0]
    }

    @Override
    boolean empresaAlreadyLikedCandidato(int candidatoId, int empresaId){
        def row = sql.firstRow("""
            SELECT EXISTS (
                SELECT 1
                FROM status_match
                WHERE id_empresa = ?
                  AND id_candidato = ?
                  AND empresa_curtiu = TRUE
            )
        """, [empresaId, candidatoId])

        row[0]
    }

    @Override
    Curtida getCurtidaObject(int candidatoId,int empresaId){
        def row = sql.firstRow("""
            SELECT *
            FROM status_match
            WHERE id_empresa = ?
            AND id_candidato = ?
        """, [empresaId,candidatoId])

        Curtida curtida = new Curtida()

        curtida.setId(row.id_status_match)
        curtida.setIdEmpresa(row.id_empresa)
        curtida.setIdCandidato(row.id_candidato)
        curtida.setCandidato_curtiu(row.candidato_curtiu)
        curtida.setEmpresa_curtiu(row.empresa_curtiu)

        curtida
    }
}
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
        sql.rows("SELECT * FROM dados_curtidas").collect { row ->

            Curtida curtida = new Curtida()

            curtida.setId(row.id_dado_curtida)
            curtida.setIdEmpresa(row.id_empresa)
            curtida.setIdVaga(row.id_vaga)
            curtida.setIdCandidato(row.id_candidato)
            curtida.setStatusCurtidaCandidato(row.status_curtida_candidato)
            curtida.setStatusCurtidaEmpresa(row.status_curtida_empresa)

            curtida
        }
    }

    @Override
    Curtida findCurtidaById(int id) {

        def row = sql.firstRow("""
            SELECT *
            FROM dados_curtidas
            WHERE id_dado_curtida = ?
        """, id)

        Curtida curtida = new Curtida()

        curtida.setId(row.id_dado_curtida)
        curtida.setIdEmpresa(row.id_empresa)
        curtida.setIdVaga(row.id_vaga)
        curtida.setIdCandidato(row.id_candidato)
        curtida.setStatusCurtidaCandidato(row.status_curtida_candidato)
        curtida.setStatusCurtidaEmpresa(row.status_curtida_empresa)

        curtida
    }

    /*
     * Insere uma curtida de uma vaga.
     *
     * Usado pelo CANDIDATO.
     */
    @Override
    void insertCurtida(Curtida curtida) {

        def params = [
                curtida.getIdEmpresa(),
                curtida.getIdVaga(),
                curtida.getIdCandidato(),
                curtida.getStatusCurtidaEmpresa(),
                curtida.getStatusCurtidaCandidato()
        ]

        sql.execute("""
            INSERT INTO dados_curtidas (
                id_empresa,
                id_vaga,
                id_candidato,
                status_curtida_empresa,
                status_curtida_candidato
            )
            VALUES (?, ?, ?, ?, ?)
        """, params)
    }

    @Override
    void deleteCurtida(int id) {

        sql.execute("""
            DELETE FROM dados_curtidas
            WHERE id_dado_curtida = ?
        """, id)
    }

    /*
     * Atualização genérica de uma linha específica.
     *
     * Não deve ser usada para o fluxo normal
     * de curtida do candidato/empresa.
     */
    @Override
    void updateCurtida(Curtida curtida) {

        def params = [
                curtida.getIdEmpresa(),
                curtida.getIdVaga(),
                curtida.getIdCandidato(),
                curtida.getStatusCurtidaEmpresa(),
                curtida.getStatusCurtidaCandidato(),
                curtida.getId()
        ]

        sql.execute("""
            UPDATE dados_curtidas
            SET id_empresa = ?,
                id_vaga = ?,
                id_candidato = ?,
                status_curtida_empresa = ?,
                status_curtida_candidato = ?
            WHERE id_dado_curtida = ?
        """, params)
    }

    /*
     * Verifica se já existe uma curtida
     * daquele candidato naquela vaga.
     */
    @Override
    boolean curtidaVagaAlreadyExists(int idCandidato, int idVaga) {

        def row = sql.firstRow("""
            SELECT EXISTS (
                SELECT 1
                FROM dados_curtidas
                WHERE id_vaga = ?
                  AND id_candidato = ?
            )
        """, [idVaga, idCandidato])

        row[0]
    }

    /*
     * Verifica se já existe qualquer registro
     * entre aquela empresa e aquele candidato.
     */
    @Override
    boolean curtidaEmpresaAlreadyExists(int idEmpresa, int idCandidato) {

        def row = sql.firstRow("""
            SELECT EXISTS (
                SELECT 1
                FROM dados_curtidas
                WHERE id_empresa = ?
                  AND id_candidato = ?
            )
        """, [idEmpresa, idCandidato])

        row[0]
    }

    /*
     * CANDIDATO:
     * altera somente a decisão dele para uma vaga.
     *
     * O status da empresa permanece intacto.
     */
    @Override
    void updateCurtidaCandidato(
            int idVaga,
            int idCandidato,
            boolean status
    ) {

        sql.execute("""
            UPDATE dados_curtidas
            SET status_curtida_candidato = ?
            WHERE id_vaga = ?
              AND id_candidato = ?
        """, [status, idVaga, idCandidato])
    }

    /*
     * EMPRESA:
     * altera somente o status da empresa.
     *
     * Como a empresa está curtindo o candidato,
     * todas as vagas dessa empresa para esse candidato
     * são atualizadas.
     */
    @Override
    void updateCurtidaEmpresa(
            int idEmpresa,
            int idCandidato,
            boolean status
    ) {

        sql.execute("""
            UPDATE dados_curtidas
            SET status_curtida_empresa = ?
            WHERE id_empresa = ?
              AND id_candidato = ?
        """, [status, idEmpresa, idCandidato])
    }

    /*
     * EMPRESA:
     * pode curtir um candidato que nunca curtiu
     * nenhuma vaga dessa empresa.
     *
     * Cria uma linha para cada vaga da empresa.
     */
    @Override
    void insertCurtidaEmpresa(
            int idEmpresa,
            int idCandidato,
            boolean status
    ) {

        sql.execute("""
            INSERT INTO dados_curtidas (
                id_empresa,
                id_vaga,
                id_candidato,
                status_curtida_empresa,
                status_curtida_candidato
            )
            SELECT
                id_empresa,
                id_vaga,
                ?,
                ?,
                false
            FROM dados_vagas
            WHERE id_empresa = ?
        """, [idCandidato, status, idEmpresa])
    }
}
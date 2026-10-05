package org.example.dao

import org.example.model.Curtida

interface CurtidaDAO {

    List<Curtida> getAllCurtidas()

    Curtida findCurtidaById(int id)

    void insertCurtida(Curtida curtida)

    void deleteCurtida(int id)

    void updateCurtida(Curtida curtida)

    boolean curtidaVagaAlreadyExists(int idCandidato, int idVaga)

    boolean curtidaEmpresaAlreadyExists(int idEmpresa, int idCandidato)

    void updateCurtidaCandidato(int idVaga, int idCandidato, boolean status)

    void updateCurtidaEmpresa(int idEmpresa, int idCandidato, boolean status)

    void insertCurtidaEmpresa(int idEmpresa, int idCandidato, boolean status)
}

package org.example.dao

import org.example.model.Curtida

interface CurtidaDAO {

    List<Curtida> getAllCurtidas()

    Curtida findCurtidaById(int id)

    void insertCurtida(int candidatoId,int empresaId,boolean candidatoCurtiu,boolean empresaCurtiu)

    Curtida getCurtidaObject(int candidatoId,int empresaId)

    void deleteCurtida(int id)

    void updateCurtida(Curtida curtida)

    boolean candidatoAlreadyLikedEmpresa(int candidatoId,int empresaId)

    boolean empresaAlreadyLikedCandidato(int candidatoId, int empresaId)

}

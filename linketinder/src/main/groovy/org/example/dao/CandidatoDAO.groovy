package org.example.dao

import org.example.model.Candidato

interface CandidatoDAO {
    List<Candidato> getAllCandidatos();

    Candidato findCandidatoById(int id);

    void insertCandidato(Candidato candidato);

    void deleteCandidato(int id);

    void updateCandidato(Candidato candidato);
}
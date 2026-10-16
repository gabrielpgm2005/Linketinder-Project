package org.example.dao

import org.example.model.Candidato
import org.example.model.Vaga

interface CandidatoDAO {
    List<Candidato> getAllCandidatos();

    Candidato findCandidatoById(int id);

    void insertCandidato(Candidato candidato);

    void deleteCandidato(int id);

    void updateCandidato(Candidato candidato);

    void salvarCurtidaDoCandidato(Candidato candidato, Vaga vaga, CurtidaDAO curtidaDB);

    void salvarCompetenciasDoCandidatoNoBD(Candidato candidato,CompetenciaDAO competenciaDB);

    int getIdAntesDeSalvarNoBd()
}
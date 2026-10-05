package org.example.dao

import org.example.model.Competencia


interface CompetenciaDAO {
    List<Competencia> getAllCompetencias();
    Competencia findCompetenciaById(int id);
    void insertCompetencia(Competencia competencia);
    void deleteCompetencia(int id);
    void updateCompetencia(Competencia competencia);
    int findCompetenciaId(String competencia);
}

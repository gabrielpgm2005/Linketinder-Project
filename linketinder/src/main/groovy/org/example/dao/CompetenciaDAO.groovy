package org.example.dao

import org.example.model.Competencia


interface CompetenciaDAO {
    List<Competencia> getAllCompetencias();
    Competencia findCompetenciaById(int id);
    void insertCompetencia(String competenciaStr) ;
    void deleteCompetencia(int id);
    void updateCompetencia(Competencia competencia);
    int findCompetenciaId(String competenciaStr);
    boolean competenciaExists(int idCompetencia);
}

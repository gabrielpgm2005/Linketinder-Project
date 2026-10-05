package org.example.dao

import org.example.model.Vaga

interface VagaDAO {
    List<Vaga> getAllVagas();
    Vaga findVagaById(int id);
    void insertVaga(Vaga vaga);
    void deleteVaga(int id);
    void updateVaga(Vaga vaga);
}
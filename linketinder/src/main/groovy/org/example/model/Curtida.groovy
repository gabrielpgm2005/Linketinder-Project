package org.example.model

import org.example.dao.SqlCurtidaDAO

class Curtida {
    private int id;
    private int idEmpresa;
    private int idCandidato;
    private boolean empresa_curtiu
    private boolean candidato_curtiu

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getIdEmpresa() {
        return idEmpresa
    }

    void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa
    }

    int getIdCandidato() {
        return idCandidato
    }

    void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato
    }

    boolean getCandidato_curtiu() {
        return candidato_curtiu
    }

    void setCandidato_curtiu(boolean candidato_curtiu) {
        this.candidato_curtiu = candidato_curtiu
    }

    boolean getEmpresa_curtiu() {
        return empresa_curtiu
    }

    void setEmpresa_curtiu(boolean empresa_curtiu) {
        this.empresa_curtiu = empresa_curtiu
    }
}

package org.example.model

public class Curtida {
    private int id;
    private int idEmpresa;
    private int idVaga;
    private int idCandidato;
    private boolean statusCurtidaEmpresa;
    private boolean statusCurtidaCandidato;

    int getIdVaga() {
        return idVaga
    }

    void setIdVaga(int idVaga) {
        this.idVaga = idVaga
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getIdEmpresa() {
        return idEmpresa
    }

    void setIdEmpresa(int id_empresa) {
        this.idEmpresa = id_empresa
    }

    boolean getStatusCurtidaEmpresa() {
        return statusCurtidaEmpresa
    }

    void setStatusCurtidaEmpresa(boolean statusCurtidaEmpresa) {
        this.statusCurtidaEmpresa = statusCurtidaEmpresa
    }

    int getIdCandidato() {
        return idCandidato
    }

    void setIdCandidato(int idCndidato) {
        this.idCandidato = idCandidato
    }

    boolean getStatusCurtidaCandidato() {
        return statusCurtidaCandidato
    }

    void setStatusCurtidaCandidato(boolean statusCurtidaCandidato) {
        this.statusCurtidaCandidato = statusCurtidaCandidato
    }
}

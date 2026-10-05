package org.example.model

public class Vaga {
    private int id;
    private int idEmpresa;
    private String nome;
    private String descricao;
    private String local;
    private String[] competencias;

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

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getLocal() {
        return local
    }

    void setLocal(String local) {
        this.local = local
    }

    String[] getCompetencias() {
        return competencias
    }

    void setCompetencias(String[] competencias) {
        this.competencias = competencias
    }
}


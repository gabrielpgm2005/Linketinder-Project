package org.example.model

class Vaga {
    private int id;
    private int idEmpresa;
    private String nome;
    private String descricao;
    private String local;
    private List<String> competencias = new LinkedList<String>();

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

    List<String> getCompetencias() {
        return competencias
    }

    void setCompetencias(List<String> competencias) {
        this.competencias = competencias
    }
    void adicionarCompetencia(String competencia){
        this.competencias.add(competencia)
    }

    void mostrarVagaAsCegas(){
        println "nome da vaga: ${this.nome}"
        println "Descrição: ${this.descricao}"
        println "local: ${this.local}"
        println "Competencias: ${this.competencias}"
    }
}


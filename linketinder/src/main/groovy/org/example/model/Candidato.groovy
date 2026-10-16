package org.example.model;

import org.example.dao.CandidatoDAO;
import org.example.dao.CurtidaDAO;


class Candidato {

    private int id;
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private String email;
    private String cpf;
    private String pais;
    private String cep;
    private String descricao;
    private String Senha;
    private List <String> competencias = new LinkedList<String>();

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getSobrenome() {
        return sobrenome;
    }

    void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    String getDataDeNascimento() {
        return dataDeNascimento;
    }

    void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPais() {
        return pais;
    }

    void setPais(String pais) {
        this.pais = pais;
    }

    String getCpf() {
        return cpf;
    }

    void setCpf(String cpf) {
        this.cpf = cpf;
    }

    String getCep() {
        return cep;
    }

    void setCep(String cep) {
        this.cep = cep;
    }

    String getDescricao() {
        return descricao;
    }

    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    List<String> getCompetencias() {
        return competencias;
    }

    void setCompetencias(List<String> competencias) {
        this.competencias = competencias;
    }

    void adicionarCompetencia(String competencia){
        this.competencias.add(competencia);
    }

    String getSenha() {
        return Senha;
    }

    void setSenha(String senha) {
        Senha = senha;
    }

    void procurarVaga(List<Vaga> vagas, Scanner scanner, CurtidaDAO curtidaDB, CandidatoDAO candidatoDB) {
        for (vaga in vagas){
            vaga.mostrarVagaAsCegas()
            print "Digite 's' se deseja curtir a vaga, e 'n' se não: "
            String resposta = scanner.nextLine().toLowerCase()
            if(resposta == "s"){
                candidatoDB.salvarCurtidaDoCandidato(this,vaga,curtidaDB)
            }
        }
    }

    void mostrarCandidatoAsCegas(){
        println "Descrição do candidato: ${this.descricao}"
        println "Competencias: ${this.competencias}"
    }


    @Override
    String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                ", descricao='" + descricao + '\'' +
                ", Senha='" + Senha + '\'' +
                '}';
    }
}

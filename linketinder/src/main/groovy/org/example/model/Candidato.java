package org.example.model;
import java.util.Arrays;

public class Candidato {

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
    private String[] competencias;

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

    String[] getCompetencias() {
        return competencias;
    }

    void setCompetencias(String[] competencias) {
        this.competencias = competencias;
    }

    String getSenha() {
        return Senha;
    }

    void setSenha(String senha) {
        Senha = senha;
    }


    @Override
    public String toString() {
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

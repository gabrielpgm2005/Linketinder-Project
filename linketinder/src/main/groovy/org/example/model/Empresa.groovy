package org.example.model
import java.util.Arrays;

public class Empresa {
    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String descricao;
    private String pais;
    private String cep;
    List<Vaga> vagas = new ArrayList<>();
    private String Senha;

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getPais() {
        return pais
    }

    void setPais(String pais) {
        this.pais = pais
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getCep() {
        return cep
    }

    void setCep(String cep) {
        this.cep = cep
    }


    String getSenha() {
        return Senha
    }

    void setSenha(String senha) {
        Senha = senha
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                ", Senha='" + Senha + '\'' +
                '}';
    }
}


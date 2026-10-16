package org.example.model

import org.example.Pessoas
import org.example.dao.CompetenciaDAO
import org.example.dao.CurtidaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.SqlCompetenciaDAO
import org.example.dao.SqlVagaCompetenciaDAO
import org.example.dao.VagaDAO


class Empresa {
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

    void procurarCandidatos(EmpresaDAO empresaDB,CurtidaDAO curtidaDB, List<Candidato> candidatos, Scanner scanner){
        for(candidato in candidatos){
            candidato.mostrarCandidatoAsCegas()
            print "Digite 's' se deseja curtir o candidato, e 'n' se não: "
            String resposta = scanner.nextLine().toLowerCase()
            if(resposta == "s"){
                empresaDB.salvarCurtidaDaEmpresa(this,candidato,curtidaDB)
            }
        }
    }

    void adicionarVaga(Empresa empresa,VagaDAO vagaDB) {
        Vaga vaga = criarVaga(vagaDB,new Scanner(System.in))

        vagaDB.insertVaga(vaga)

        adicionarCompetencias(vaga.id,new SqlCompetenciaDAO())


        empresa.vagas.add(vaga)
    }


    void setCompetencias(List<String> competencias) {
        this.competencias = competencias
    }

    void adicionarCompetencia(String competencia){
        this.competencias.add(competencia)
    }

    List<Vaga> getVagas() {
        return vagas
    }

    void setVagas(List<Vaga> vagas) {
        this.vagas = vagas
    }

    static void adicionarCompetencias(int vagaId,CompetenciaDAO competenciaDB) {

        String[] competenciasStr = Pessoas.pegarCompetenciasDoUsuario(new Scanner(System.in))

        for(String competencia in competenciasStr){
            competenciaDB.insertCompetencia(competencia)
            new SqlVagaCompetenciaDAO().insert(
                    vagaId,
                    competenciaDB.findCompetenciaId(competencia))
        }
    }

    Vaga criarVaga(VagaDAO vagaDB,Scanner scanner){
        Vaga vaga = new Vaga()

        vaga.id = vagaDB.getIdAntesDeSalvarNoBd()

        vaga.idEmpresa = this.id

        println "Entre com o nome da vaga: "
        vaga.nome = scanner.nextLine()

        println "Entre com a descrição da vaga: "
        vaga.descricao = scanner.nextLine()

        println "Entre com o local da vaga: "
        vaga.local = scanner.nextLine()

        vaga
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


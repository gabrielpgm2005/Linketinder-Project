package org.example

import org.example.dao.CandidatoDAO
import org.example.dao.CompetenciaDAO
import org.example.model.Candidato
class Candidatos extends Pessoas{

    static void adicionarCandidato(CandidatoDAO candidatos, Scanner scanner,CompetenciaDAO competenciaDB) {

        Candidato candidato = criarCandidato(candidatos,scanner)

        adicionarCandidatoNaLista(candidatos, candidato)

        adicionarCompetencias(candidato,competenciaDB)

        candidatos.salvarCompetenciasDoCandidatoNoBD(candidato,competenciaDB)
    }

    static void adicionarCandidatoNaLista(CandidatoDAO candidatos,Candidato candidato){
        candidatos.insertCandidato(candidato)
    }

    static void adicionarCompetencias(Candidato candidato,CompetenciaDAO competenciaDB) {

        String[] competenciasStr = pegarCompetenciasDoUsuario(new Scanner(System.in))

        for(String competencia in competenciasStr){
            competenciaDB.insertCompetencia(competencia)
            candidato.adicionarCompetencia(competencia)
        }
    }

    static Candidato logar(CandidatoDAO candidatos,Scanner scanner){
        println "Entre com o id do candidato que deseja logar"
        int id = scanner.nextInt()
        scanner.nextLine()
        candidatos.findCandidatoById(id)
    }

    static Candidato criarCandidato(CandidatoDAO candidatoDB,Scanner scanner){
        Candidato candidato = new Candidato()

        candidato.id = candidatoDB.getIdAntesDeSalvarNoBd()

        println "Entre com o nome do candidato: "
        candidato.nome = scanner.nextLine()

        println "Entre com o sobrenome do candidato: "
        candidato.sobrenome = scanner.nextLine()

        println "Entre com a data de nascimento"
        candidato.dataDeNascimento = scanner.nextLine()

        println "Entre com o email"
        candidato.email = scanner.nextLine()

        println "Entre com o cpf: "
        candidato.cpf = scanner.nextLine()

        println "Entre com o pais que o candidato vive: "
        candidato.pais = scanner.nextLine()

        println "Entre com o cep do candidato: "
        candidato.cep = scanner.nextLine()

        println "Entre com uma descrição para o candidato: "
        candidato.descricao = scanner.nextLine()

        println "Entre com a senha"
        candidato.senha = scanner.nextLine()

        candidato
    }
    

}


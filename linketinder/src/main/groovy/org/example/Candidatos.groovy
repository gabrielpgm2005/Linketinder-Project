package org.example

import org.example.dao.CandidatoDAO
import org.example.dao.CurtidaDAO
import org.example.dao.SqlCandidatoCompetenciaDAO
import org.example.dao.SqlCompetenciaDAO
import org.example.dao.SqlCurtidaDAO
import org.example.model.Candidato
import org.example.model.Competencia
import org.example.model.Curtida
import org.example.model.Vaga

class Candidatos extends Pessoas{

    static void adicionarCandidato(CandidatoDAO candidatos, Scanner scanner) {

        Candidato candidato = new Candidato()

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

        adicionarCandidatoNaLista(candidatos, candidato)

        adicionarCompetencias(candidato, scanner)
    }

    static void adicionarCandidatoNaLista(CandidatoDAO candidatos,Candidato candidato){
        candidatos.insertCandidato(candidato)
    }

    static void adicionarCompetencias(Candidato candidato, Scanner scanner) {

        println "Entre com as competencias que deseja adicionar (separadas por ','): "

        String[] competencias = scanner.nextLine().split(",")

        SqlCompetenciaDAO competenciaDAO = new SqlCompetenciaDAO()
        SqlCandidatoCompetenciaDAO candidatoCompetenciaDAO =
                new SqlCandidatoCompetenciaDAO()

        for (String competencia in competencias) {

            competencia = competencia.trim()

            Competencia c = new Competencia()
            c.setCompetencia(competencia)

            competenciaDAO.insertCompetencia(c)

            int idCompetencia =
                    competenciaDAO.findCompetenciaId(competencia)

            candidatoCompetenciaDAO.insert(
                    candidato.id,
                    idCompetencia
            )
        }
    }

    static Candidato logar(CandidatoDAO candidatos,Scanner scanner){
        println "Entre com o id do candidato que deseja logar"
        int id = scanner.nextInt()
        scanner.nextLine()
        candidatos.findCandidatoById(id)
    }

    static buscarVaga(Candidato candidato, Vaga[] vagas, Scanner scanner) {

        CurtidaDAO curtidaDB = new SqlCurtidaDAO()

        for (Vaga vaga in vagas) {

            println "--------------------------------"
            println "Vaga: ${vaga.nome}"
            println "Descricao: ${vaga.descricao}"
            println "Local: ${vaga.local}"
            println "Competencias buscadas: ${vaga.competencias}"

            print "Deseja dar like na vaga? (sim/nao): "
            String resposta = scanner.nextLine()

            if (resposta != "sim" && resposta != "nao") {
                continue
            }

            boolean curtiu = resposta == "sim"

            if (curtidaDB.curtidaVagaAlreadyExists(
                    candidato.id,
                    vaga.id
            )) {

                curtidaDB.updateCurtidaCandidato(
                        vaga.id,
                        candidato.id,
                        curtiu
                )

            } else {

                Curtida curtida = new Curtida()

                curtida.idEmpresa = vaga.idEmpresa
                curtida.idVaga = vaga.id
                curtida.idCandidato = candidato.id

                curtida.statusCurtidaEmpresa = false
                curtida.statusCurtidaCandidato = curtiu

                curtidaDB.insertCurtida(curtida)
            }
        }
    }
}


package org.example

import org.example.dao.CurtidaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.SqlCompetenciaDAO
import org.example.dao.SqlCurtidaDAO
import org.example.dao.SqlEmpresaDAO
import org.example.dao.SqlVagaCompetenciaDAO
import org.example.dao.SqlVagaDAO
import org.example.model.Candidato
import org.example.model.Competencia
import org.example.model.Empresa
import org.example.model.Vaga

class Empresas extends Pessoas{


    static void adicionarEmpresa(EmpresaDAO empresas,Scanner scanner){
        Empresa empresa = new Empresa()
        println "Entre com o nome da empresa: "
        empresa.nome = scanner.nextLine()
        println "Entre com o email da empresa: "
        empresa.email = scanner.nextLine()
        println "Entre com o cnpj da empresa: "
        empresa.cnpj = scanner.nextLine()
        println "Entre com o país onde a empresa reside: "
        empresa.pais = scanner.nextLine()
        println "Entre com o CEP da empresa: "
        empresa.cep = scanner.nextLine()
        println "Entre com uma descrição para a empresa: "
        empresa.descricao = scanner.nextLine()
        println "Entre com uma senha"
        empresa.senha = scanner.nextLine()
        adicionarEmpresaNaLista(empresas,empresa)
    }
    static void adicionarEmpresaNaLista(EmpresaDAO empresas,Empresa empresa){
        empresas.insertEmpresa(empresa)
    }

    static Empresa logar(EmpresaDAO empresas,Scanner scanner){
        println "Entre com o id da empresa que deseja logar"
        int id = scanner.nextInt()
        scanner.nextLine()
        empresas.findEmpresaById(id)
    }

    static adicionarVaga(Empresa empresa, Scanner scanner) {
        Vaga vaga = new Vaga()

        vaga.idEmpresa = empresa.id

        println "Entre com o nome da vaga: "
        vaga.nome = scanner.nextLine()

        println "Entre com a descrição da vaga: "
        vaga.descricao = scanner.nextLine()

        println "Entre com o local da vaga: "
        vaga.local = scanner.nextLine()

        new SqlVagaDAO().insertVaga(vaga)

        adicionarCompetencias(vaga, scanner)

        empresa.vagas.add(vaga)
    }

    static void adicionarCompetencias(Vaga vaga, Scanner scanner) {

        println "Entre com as competencias exigidas pela vaga (separadas por ','): "

        String[] competencias = scanner.nextLine().split(",")

        SqlCompetenciaDAO competenciaDAO = new SqlCompetenciaDAO()
        SqlVagaCompetenciaDAO vagaCompetenciaDAO = new SqlVagaCompetenciaDAO()

        for (String competencia in competencias) {

            competencia = competencia.trim()

            Competencia c = new Competencia()
            c.competencia = competencia

            competenciaDAO.insertCompetencia(c)

            int idCompetencia = competenciaDAO.findCompetenciaId(competencia)

            vagaCompetenciaDAO.insert(
                    vaga.getId(),
                    idCompetencia
            )
        }
    }

    static void buscarCandidatos(
            Empresa empresa,
            Candidato[] candidatos,
            Scanner scanner
    ) {

        CurtidaDAO curtidaDB = new SqlCurtidaDAO()

        for (Candidato candidato in candidatos) {

            println "--------------------------------"
            println "Candidato: ${candidato.nome}"
            println "Descricao: ${candidato.descricao}"

            print "Deseja dar like neste candidato? (sim/nao): "
            String resposta = scanner.nextLine()

            if (resposta != "sim" && resposta != "nao") {
                continue
            }

            boolean curtiu = resposta == "sim"

            if (curtidaDB.curtidaEmpresaAlreadyExists(
                    empresa.id,
                    candidato.id
            )) {

                curtidaDB.updateCurtidaEmpresa(
                        empresa.id,
                        candidato.id,
                        curtiu
                )

            } else {

                curtidaDB.insertCurtidaEmpresa(
                        empresa.id,
                        candidato.id,
                        curtiu
                )
            }
        }
    }
}


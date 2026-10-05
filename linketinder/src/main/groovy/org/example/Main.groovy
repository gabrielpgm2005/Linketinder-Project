package org.example

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.example.dao.EmpresaDAO
import org.example.dao.SqlCandidatoDAO
import org.example.dao.SqlEmpresaDAO
import org.example.dao.SqlVagaDAO
import org.example.model.Candidato
import org.example.model.Empresa
import org.example.model.Vaga

def candidatoDB = new SqlCandidatoDAO()
def empresaDB = new SqlEmpresaDAO()
def pessoaLogada = null
String resposta = "s"
Scanner scanner = new Scanner(System.in)

while(!resposta.equals("q")){
    println "Linketinder!!!"
    println "Digite 1 se deseja listar todas empresas"
    println "Digite 2 se deseja listar todos candidatos"
    println "Digite 3 se deseja adicionar uma nova empresa"
    println "Digite 4 se deseja adicionar um novo candidato"
    println "Digite 5 se deseja logar como Candidato"
    println "Digite 6 se deseja logar como Empresa"
    println "Digite 7 se deseja Adicionar uma vaga (Apenas se já estiver logado como empresa)"
    println "Digite 8 se deseja buscar vagas (Apenas disponivel se já estiver logado como candidato)"
    println "Digite 9 se deseja buscar candidatos (Apenas disponivel se já estiver logado como empresa)"
    //println "Digite 7 se deseja rolar o feed (Você precisa estar logado)"
    println "Digite q se quiser encerrar o programa"
    resposta = scanner.nextLine()

    switch (resposta){
        case "1":
            Empresas.display(empresaDB.getAllEmpresas())
            break

        case "2":
            Candidatos.display(candidatoDB.getAllCandidatos())
            break

        case "3":
            Empresas.adicionarEmpresa(empresaDB,scanner)
            break

        case "4":
            Candidatos.adicionarCandidato(candidatoDB,scanner)
            break

        case "5":
            pessoaLogada = Candidatos.logar(candidatoDB,scanner)
            break

        case "6":
            pessoaLogada = Empresas.logar(empresaDB,scanner)
            break

        case "7":
            if(pessoaLogada.getClass() != Empresa){
                break
            }
            Empresas.adicionarVaga(pessoaLogada as Empresa,scanner)
            break

        case "8":
            if(pessoaLogada.getClass() != Candidato){
                break
            }
            Vaga[] vagas = new SqlVagaDAO().getAllVagas()
            Candidatos.buscarVaga(pessoaLogada as Candidato,vagas,scanner)
            break

        case "9":
            if(pessoaLogada.getClass() != Empresa){
                break
            }
            Candidato[] candidatos = candidatoDB.getAllCandidatos()
            Empresas.buscarCandidatos(pessoaLogada as Empresa,candidatos,scanner)
            break

        case "q":
            break

        default:
            println "Digite uma opção válida!"
    }
}
scanner.close()
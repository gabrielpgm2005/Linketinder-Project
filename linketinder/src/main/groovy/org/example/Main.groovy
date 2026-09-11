package org.example

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

ArrayList candidatos = new JsonSlurper().parse(new File("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/candidatos.json")) as ArrayList
ArrayList empresas = new JsonSlurper().parse(new File("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/empresas.json")) as ArrayList
ArrayList curtidas = new JsonSlurper().parse(new File("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/curtidas.json")) as ArrayList
Map<String,Object> pessoaLogada = null
ArrayList<Map<String,String>> possiveisInteressados = null
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
    println "Digite 7 se deseja rolar o feed (Você precisa estar logado)"
    println "Digite q se quiser encerrar o programa"
    resposta = scanner.nextLine()

    switch (resposta){
        case "1":
            Empresas.display(empresas)
            break

        case "2":
            Candidatos.display(candidatos)
            break

        case "3":
            Empresas.adicionarEmpresa(empresas,scanner)
            break

        case "4":
            Candidatos.adicionarCandidato(candidatos,scanner)
            break

        case "5":
            pessoaLogada = Pessoas.logar(candidatos,scanner)
            possiveisInteressados = empresas
            break

        case "6":
            pessoaLogada = Pessoas.logar(empresas,scanner)
            possiveisInteressados = candidatos
            break

        case "7":
            CurtidasManager.feed(pessoaLogada,possiveisInteressados,curtidas,scanner)
            break

        case "q":
            new File("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/candidatos.json").text = new JsonBuilder(candidatos).toPrettyString()
            new File("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/empresas.json").text = new JsonBuilder(empresas).toPrettyString()
            CurtidasManager.atualizarArquivo("/home/gabriel/acelera/Linketinder-Project/linketinder/src/main/groovy/org/example/jsons/curtidas.json",curtidas)
            break

        default:
            println "Digite uma opção válida!"
    }
}
scanner.close()
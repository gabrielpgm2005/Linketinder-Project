package org.example

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

ArrayList candidatos = new JsonSlurper().parse(new File("./jsons/candidatos.json")) as ArrayList
ArrayList empresas = new JsonSlurper().parse(new File("./jsons/empresas.json")) as ArrayList

String resposta = "s"
Scanner scanner = new Scanner(System.in)

while(!resposta.equals("q")){
    println "Linketinder!!!"
    println "Digite 1 se deseja listar todas empresas"
    println "Digite 2 se deseja listar todos candidatos"
    println "Digite 3 se deseja adicionar uma nova empresa"
    println "Digite 4 se deseja adicionar um novo candidato"
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
            Empresas.adicionar(empresas,scanner)
            break

        case "4":
            Candidatos.adicionar(candidatos,scanner)
            break

        case "q":
            new File("./jsons/candidatos.json").text = new JsonBuilder(candidatos).toPrettyString()
            new File("./jsons/empresas.json").text = new JsonBuilder(empresas).toPrettyString()
            break

        default:
            println "Digite uma opção válida!"
    }

}
package org.example

class Candidatos extends Pessoas{

    static void adicionarCandidato(List candidatos,Scanner scanner){
        LinkedHashMap<String,Object> candidato = new LinkedHashMap<>()
        println "Entre com o nome do candidato: "
        candidato.nome = scanner.nextLine()
        println "Entre com o cpf: "
        candidato.cpf = scanner.nextLine()
        println "Entre com a idade do candidato: "
        candidato.idade = scanner.nextLine()
        println "Entre com o pais que o candidato vive: "
        candidato.pais = scanner.nextLine()
        println "Entre com o cep do candidato: "
        candidato.cep = scanner.nextLine()
        println "Entre com uma descrição para o candidato: "
        candidato.descricao = scanner.nextLine()
        println "Entre com as habilidades do candidato(Separadas por , ): "
        candidato.competenciasQueBuscam = scanner.nextLine().split(",")
        adicionarCandidatoNaLista(candidatos,candidato)
    }

    static void adicionarCandidatoNaLista(List candidatos,Map candidato){
        candidatos.add(candidato)
    }

}


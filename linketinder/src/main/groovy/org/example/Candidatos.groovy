package org.example

class Candidatos extends Pessoas{

    static void adicionar(List candidatos,Scanner scanner){
        println "Entre com o nome do candidato: "
        String nome = scanner.nextLine()
        println "Entre com o cpf: "
        String cpf = scanner.nextLine()
        println "Entre com a idade do candidato: "
        String idade = scanner.nextLine()
        println "Entre com o pais que o candidato vive: "
        String pais = scanner.nextLine()
        println "Entre com o cep do candidato: "
        String cep = scanner.nextLine()
        println "Entre com uma descrição para o candidato: "
        String descricao = scanner.nextLine()
        println "Entre com as habilidades do candidato(Separadas por , ): "
        String[] habilidades = scanner.nextLine().split(",")

        candidatos.add(
                nome:nome,cpf:cpf,idade:idade,pais:pais,cep:cep,descricao:descricao,
                habilidades:habilidades
        )

    }

}


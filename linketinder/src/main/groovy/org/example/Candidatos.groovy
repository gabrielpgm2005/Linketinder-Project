package org.example

class Candidatos extends Pessoas{

    static void adicionar(List candidatos,Scanner scanner){
        print "Entre com o nome do candidato: "
        String nome = scanner.nextLine()
        print "Entre com o cpf: "
        String cpf = scanner.nextLine()
        print "Entre com a idade do candidato: "
        String idade = scanner.nextLine()
        print "Entre com o pais que o candidato vive: "
        String pais = scanner.nextLine()
        print "Entre com o cep do candidato: "
        String cep = scanner.nextLine()
        print "Entre com uma descrição para o candidato: "
        String descricao = scanner.nextLine()
        print "Entre com as habilidades do candidato(Separadas por , ): "
        String[] habilidades = scanner.nextLine().split(",")

        candidatos.add(
                nome:nome,cpf:cpf,idade:idade,pais:pais,cep:cep,descricao:descricao,
                habilidades:habilidades
        )

    }

}


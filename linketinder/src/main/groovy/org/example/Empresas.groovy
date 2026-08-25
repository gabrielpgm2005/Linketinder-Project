package org.example

class Empresas extends Pessoas{


    static void adicionar(List pessoas,Scanner scanner){
        println "Entre com o nome da empresa: "
        String nome = scanner.nextLine()
        println "Entre com o email da empresa: "
        String email = scanner.nextLine()
        println "Entre com o cnpj da empresa: "
        String cnpj = scanner.nextLine()
        println "Entre com o país onde a empresa reside: "
        String pais = scanner.nextLine()
        println "Entre com o estado onde a empresa reside: "
        String estado = scanner.nextLine()
        println "Entre com o CEP da empresa: "
        String cep = scanner.nextLine()
        println "Entre com uma descrição para a empresa: "
        String descricao = scanner.nextLine()
        println "Entre com as competencias que a empresa Busca (Separado por , :"
        String[] competenciasQueBuscam = scanner.nextLine().split(",")
        pessoas.add(
                nome:nome,email:email,cnpj:cnpj,pais:pais,estado:estado,
                cep:cep,descricao:descricao,competenciasQueBuscam:competenciasQueBuscam
        )
    }
}


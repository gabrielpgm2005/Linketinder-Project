package org.example

class Empresas extends Pessoas{


    static void adicionar(List pessoas,Scanner scanner){
        print "Entre com o nome da empresa: "
        String nome = scanner.nextLine()
        print "Entre com o email da empresa: "
        String email = scanner.nextLine()
        print "Entre com o cnpj da empresa: "
        String cnpj = scanner.nextLine()
        print "Entre com o país onde a empresa reside: "
        String pais = scanner.nextLine()
        print "Entre com o estado onde a empresa reside: "
        String estado = scanner.nextLine()
        print "Entre com o CEP da empresa: "
        String cep = scanner.nextLine()
        print "Entre com uma descrição para a empresa: "
        String descricao = scanner.nextLine()
        print "Entre com as competencias que a empresa Busca (Separado por , :"
        String[] competenciasQueBuscam = scanner.nextLine().split(",")
        pessoas.add(
                nome:nome,email:email,cnpj:cnpj,pais:pais,estado:estado,
                cep:cep,descricao:descricao,competenciasQueBuscam:competenciasQueBuscam
        )
    }
}


package org.example

class Empresas extends Pessoas{


    static void adicionarEmpresa(List empresas,Scanner scanner){
        LinkedHashMap<String,Object> empresa = new LinkedHashMap<>()
        println "Entre com o nome da empresa: "
        empresa.nome = scanner.nextLine()
        println "Entre com o email da empresa: "
        empresa.email = scanner.nextLine()
        println "Entre com o cnpj da empresa: "
        empresa.cnpj = scanner.nextLine()
        println "Entre com o país onde a empresa reside: "
        empresa.pais = scanner.nextLine()
        println "Entre com o estado onde a empresa reside: "
        empresa.estado = scanner.nextLine()
        println "Entre com o CEP da empresa: "
        empresa.cep = scanner.nextLine()
        println "Entre com uma descrição para a empresa: "
        empresa.descricao = scanner.nextLine()
        println "Entre com as competencias que a empresa Busca (Separado por , :"
        empresa.competenciasQueBuscam = scanner.nextLine().split(",")
        adicionarEmpresaNaLista(empresas,empresa)
    }
    static void adicionarEmpresaNaLista(List empresas,Map empresa){
        empresas.add(empresa)
    }
}


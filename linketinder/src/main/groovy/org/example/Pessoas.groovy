package org.example

class Pessoas{

    static void display(List pessoas){
        pessoas.each {
            pessoa ->
                println "==============="
                println pessoa
                println "==============="
        }
    }

    static Map logar(ArrayList<Map<String,Object>> pessoasDoMesmoTipo,
                      Scanner scanner){
        Map pessoaLogada = null
        println "Digite seu nome: "
        String nome = scanner.nextLine()
        pessoaLogada = pessoasDoMesmoTipo.find{
            it.get("nome") == nome
        }

        if (!pessoaLogada) {
            println "Não foi possível logar, verifique se seu nome foi escrito corretamente"
            return null
        }
        return pessoaLogada
    }

    static String[] pegarCompetenciasDoUsuario(Scanner scanner){
        println "Entre com as competencias que deseja adicionar (separadas por ','): "
        String[] competenciasStr = scanner.nextLine().trim().toLowerCase().split(",")
        competenciasStr
    }


}


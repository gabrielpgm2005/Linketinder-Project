package org.example

class Pessoas{

    //TODO: Adicionar o programa para ler do arquivo e sobreescrever do arquivo
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


}


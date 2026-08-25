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


}


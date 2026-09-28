package org.example

class Calculadora {

    def somar (def a,def b){
        return a + b
    }

    BigDecimal dividir (int a,int b){
        if (b == 0){
            throw new ArithmeticException("baka")
        }
        return a/b
    }
}

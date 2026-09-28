package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

import static org.junit.jupiter.api.Assertions.*

class CalculadoraTest2 {

    @ParameterizedTest
    @MethodSource("dadosParaSomar")
    void testSomar(def a, def b, def esperado) {
        def calculadora = new Calculadora()

        assertEquals(esperado, calculadora.somar(a, b))
    }

    @Test
    void testDividir() {
        def calculadora = new Calculadora()

        assertThrows(ArithmeticException.class) {
            calculadora.dividir(1, 0)
        }
    }

    static List<Arguments> dadosParaSomar() {
        return [
                Arguments.of("oi", " pepe", "oi pepe"),
                Arguments.of(1, 3, 4),
                Arguments.of(3, 3, 6),
                Arguments.of("ma","rq","marq")
        ]
    }
}
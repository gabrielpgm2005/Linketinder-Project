package org.example

import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

@Suite
@SelectClasses([
        CalculadoraTest,
        CalculadoraTest2
])
class CalculadoraSuite {
}
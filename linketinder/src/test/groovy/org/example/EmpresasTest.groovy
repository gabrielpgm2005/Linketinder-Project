package org.example

import spock.lang.Specification

class EmpresasTest extends Specification {

    List<Map<String,Object>> empresas = new LinkedList<>()

    def "Valida se uma empresa está sendo adicionada corretamente na Lista de empresas"() {
        given: "Map com campos preenchidos,representando uma empresa"
            Map<String,Object> empresa = new HashMap<>()
            empresa.nome = "ZeroLag"
            empresa.email = "ZeroLag@email.com"
            empresa.cnpj = "100.100.100"
            empresa.pais = "Butao"
            empresa.estado = "RJ"
            empresa.cep = "1020-032"
            empresa.descricao = "Empresa focada em tirar o Lag de sistemas hospitalares"
            empresa.competenciasQueBuscam = ["JS","SQL"]

        when: "Empresa é adicionada a Lista"
            Empresas.adicionarEmpresaNaLista(empresas,empresa)

        then: "Verifica se a empresa e todos seus campos foram devidamente adicionados na lista"
            verificaCamposDeEmpresa(empresas)
    }

    static void verificaCamposDeEmpresa(List empresas){
        def empresa = empresas[0]
        assert empresa.nome == "ZeroLag"
        assert empresa.email == "ZeroLag@email.com"
        assert empresa.cnpj == "100.100.100"
        assert empresa.pais == "Butao"
        assert empresa.estado == "RJ"
        assert empresa.cep == "1020-032"
        assert empresa.descricao == "Empresa focada em tirar o Lag de sistemas hospitalares"
        assert empresa.competenciasQueBuscam == ["JS","SQL"]

    }
}

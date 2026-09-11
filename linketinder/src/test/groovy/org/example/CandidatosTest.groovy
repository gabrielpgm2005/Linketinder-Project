package org.example

import org.apache.groovy.json.internal.LazyMap
import spock.lang.Specification

class CandidatosTest extends Specification {

    ArrayList<Map<String,Object>> candidatosList = new ArrayList<>()

    def "Valida se o candidato adicionado na lista tem os campos corretos"() {
        given: "Map com campos é preenchido,representando um candidato"

            Map<String,Object> candidato = new HashMap<>()
            candidato.put("nome","Abraham")
            candidato.put("cpf","000-000-000-00")
            candidato.put("idade","21")
            candidato.put("Pais","URSS")
            candidato.put("cep","100000")
            candidato.put("descricao","Gosto de programar em C")
            candidato.put("competenciasQueBuscam",["C","C++","Java"])

        when: "Candidato é adicionado na lista"

        Candidatos.adicionarCandidatoNaLista(candidatosList,candidato)

        then: "Verifica se o candidato tem os campos especificos adicionados"

        verificaCamposDeCandidato(candidatosList)
    }

    static void verificaCamposDeCandidato(List candidatos){
        def candidato = candidatos[0]
        assert candidato.get("nome") == "Abraham"
        assert candidato.get("cpf") == "000-000-000-00"
        assert candidato.get("idade") == "21"
        assert candidato.get("Pais") == "URSS"
        assert candidato.get("cep") == "100000"
        assert candidato.get("descricao") == "Gosto de programar em C"
        assert candidato.get("competenciasQueBuscam") == ["C","C++","Java"]
    }
}

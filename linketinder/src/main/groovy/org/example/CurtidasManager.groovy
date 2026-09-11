package org.example

import groovy.json.JsonBuilder

class CurtidasManager {

    static void feed(Map<String, Object> pessoaLogada, ArrayList<Map<String, Object>> possiveisInteressados,
                     ArrayList<Map<String, String>> curtidas, Scanner scanner) {

        String resposta = ""
        ArrayList<Map<String, Object>> feed = new ArrayList<>(possiveisInteressados)

        List<Map<String, String>> pessoasInteressadas = curtidas.findAll {
            map -> map.get("pessoaDeInteresse") == pessoaLogada.get("nome") &&
                    map.get("status") == "aguardando"
        }

        pessoasInteressadas.each { possivelMatch ->

            Map<String,Object> possivelMatchObjeto = feed.find{
                it.get("nome") == possivelMatch.get("pessoaInteressada")
            }
            displayAntesDoMatch(possivelMatchObjeto)

            println "Deseja curtir? (S/N)"
            resposta = scanner.nextLine()

            Map<String, String> curtida = curtidas.find {
                it.get("pessoaInteressada") == possivelMatch.get("pessoaInteressada") &&
                        it.get("pessoaDeInteresse") == pessoaLogada.get("nome") &&
                        it.get("status") == "aguardando"
            }

            if (resposta == "S") {
                curtida.put("status", "em match")
            }
            else if (resposta == "N") {
                curtida.put("status", "falho")
            }

            feed.removeIf {
                it.get("nome") == possivelMatch.get("pessoaInteressada")
            }
        }

        feed.each { pessoaInteressada ->

            displayAntesDoMatch(pessoaInteressada)

            println "Deseja curtir? (S/N)"
            resposta = scanner.nextLine()

            if (resposta == "S") {

                String pessoaInteressadaNome = pessoaLogada.get("nome")
                String pessoaDeInteresse = pessoaInteressada.get("nome")

                Map<String, String> curtidaContraria = curtidas.find {
                    it.get("pessoaInteressada") == pessoaDeInteresse &&
                            it.get("pessoaDeInteresse") == pessoaInteressadaNome &&
                            it.get("status") == "aguardando"
                }

                if (curtidaContraria != null) {
                    curtidaContraria.put("status", "em match")

                }
                else {
                    curtidas.add(
                            pessoaInteressada: pessoaInteressadaNome,
                            pessoaDeInteresse: pessoaDeInteresse,
                            status: "aguardando"
                    )
                }
            }
        }
    }

    static void displayAntesDoMatch(Map<String,Object> pessoaInteressada) {

        println "Descrição: " + pessoaInteressada.get("descricao")

        List<String> interesses = pessoaInteressada.get("competenciasQueBuscam")

        println "Interesses: " + interesses
    }

    static void atualizarArquivo(String filePath, ArrayList<Map<String, String>> curtidas) {
        curtidas.removeAll {it.get("status") == "falho"}
        new File(filePath).text = new JsonBuilder(curtidas).toPrettyString()
    }
}

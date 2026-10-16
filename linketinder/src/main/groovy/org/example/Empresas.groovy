package org.example

import org.example.dao.CompetenciaDAO
import org.example.dao.EmpresaDAO
import org.example.dao.SqlCompetenciaDAO
import org.example.dao.SqlVagaDAO
import org.example.dao.VagaDAO
import org.example.model.Empresa
import org.example.model.Vaga

class Empresas extends Pessoas{


    static void adicionarEmpresa(EmpresaDAO empresas,Scanner scanner){
        Empresa empresa = new Empresa()
        println "Entre com o nome da empresa: "
        empresa.nome = scanner.nextLine()
        println "Entre com o email da empresa: "
        empresa.email = scanner.nextLine()
        println "Entre com o cnpj da empresa: "
        empresa.cnpj = scanner.nextLine()
        println "Entre com o país onde a empresa reside: "
        empresa.pais = scanner.nextLine()
        println "Entre com o CEP da empresa: "
        empresa.cep = scanner.nextLine()
        println "Entre com uma descrição para a empresa: "
        empresa.descricao = scanner.nextLine()
        println "Entre com uma senha"
        empresa.senha = scanner.nextLine()
        adicionarEmpresaNaLista(empresas,empresa)
    }
    static void adicionarEmpresaNaLista(EmpresaDAO empresas,Empresa empresa){
        empresas.insertEmpresa(empresa)
    }

    static Empresa logar(EmpresaDAO empresas,Scanner scanner){
        println "Entre com o id da empresa que deseja logar"
        int id = scanner.nextInt()
        scanner.nextLine()
        empresas.findEmpresaById(id)
    }

//    static adicionarVaga(Empresa empresa,VagaDAO vagaDB) {
//        Vaga vaga = empresa.criarVaga(new Scanner(System.in))
//
//        vagaDB.insertVaga(vaga)
//
//        adicionarCompetencias(vaga,new SqlCompetenciaDAO(),new SqlVagaDAO())
//
//    }

    static void adicionarCompetencias(Vaga vaga,CompetenciaDAO competenciaDB,VagaDAO vagaDB) {

        String[] competencias = pegarCompetenciasDoUsuario(new Scanner(System.in))

        for (String competencia in competencias) {
            competenciaDB.insertCompetencia(competencia)
            vaga.adicionarCompetencia(competencia)
        }
    }


}


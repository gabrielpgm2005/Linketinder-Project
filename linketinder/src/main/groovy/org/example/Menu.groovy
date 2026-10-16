package org.example

import org.example.dao.SqlCandidatoDAO
import org.example.dao.SqlCompetenciaDAO
import org.example.dao.SqlCurtidaDAO
import org.example.dao.SqlEmpresaDAO
import org.example.dao.SqlVagaDAO
import org.example.model.Candidato
import org.example.model.Empresa


class Menu {
    static Candidato candidatoLogado = null
    static Empresa empresaLogada = null

     static int MOSTRAR_EMPRESAS = 1;
     static int MOSTRAR_CANDIDATOS = 2;
     static int ADICIONAR_EMPRESA = 3;
     static int ADICIONAR_CANDIDATO = 4;
     static int LOGAR_COMO_CANDIDATO = 5;
     static int LOGAR_COMO_EMPRESA = 6;
     static int BUSCAR_VAGAS = 7;
     static int BUSCAR_CANDIDATOS = 8;
    static int ADICIONAR_VAGA = 9;


    static void mostrarMenu(){
        println "Linketinder!!!"
        println "Digite 1 se deseja listar todas empresas"
        println "Digite 2 se deseja listar todos candidatos"
        println "Digite 3 se deseja adicionar uma nova empresa"
        println "Digite 4 se deseja adicionar um novo candidato"
        println "Digite 5 se deseja logar como Candidato"
        println "Digite 6 se deseja logar como Empresa"
        println "Digite 7 se deseja buscar vagas (Apenas disponivel se já estiver logado como candidato)"
        println "Digite 8 se deseja buscar candidatos (Apenas disponivel se já estiver logado como empresa)"
        println "Digite 9 se deseja adicionar uma nova Vaga (Apenas disponivel se estiver logado como empresa)"

    }

    static void escolherOpcao(){

        Scanner scanner = new Scanner(System.in)
        String resposta = ""

        while(!resposta.equals("q")){
            mostrarMenu()
            int opcao = scanner.nextInt()
            scanner.nextLine()
            executaOpcaoEscolhida(opcao,scanner)
            println "Digite q se quiser encerrar o programa"
            resposta = scanner.nextLine()
        }
        scanner.close()

    }

    static void executaOpcaoEscolhida(int opcao,Scanner scanner){
        switch (opcao){
            case MOSTRAR_EMPRESAS:
                Empresas.display(new SqlEmpresaDAO().getAllEmpresas())
                break
            case MOSTRAR_CANDIDATOS:
                Candidatos.display(new SqlCandidatoDAO().getAllCandidatos())
                break
            case ADICIONAR_EMPRESA:
                Empresas.adicionarEmpresa(new SqlEmpresaDAO(),scanner)
                break
            case ADICIONAR_CANDIDATO:
                Candidatos.adicionarCandidato(new SqlCandidatoDAO(),scanner,new SqlCompetenciaDAO())
                break
            case LOGAR_COMO_CANDIDATO:
                candidatoLogado = Candidatos.logar(new SqlCandidatoDAO(),scanner)
                empresaLogada = null
                break
            case LOGAR_COMO_EMPRESA:
                empresaLogada = Empresas.logar(new SqlEmpresaDAO(),scanner)
                candidatoLogado = null
                break
            case BUSCAR_VAGAS:
                if(!candidatoLogado) return
                candidatoLogado.procurarVaga(
                        new SqlVagaDAO().getAllVagas(),
                        scanner,
                        new SqlCurtidaDAO(),
                        new SqlCandidatoDAO()
                )
                break
            case BUSCAR_CANDIDATOS:
                if(!empresaLogada) return
                empresaLogada.procurarCandidatos(
                        new SqlEmpresaDAO(),
                        new SqlCurtidaDAO(),
                        new SqlCandidatoDAO().getAllCandidatos(),
                scanner)
                break
            case ADICIONAR_VAGA:
                if(!empresaLogada) return
                empresaLogada.adicionarVaga(empresaLogada,new SqlVagaDAO())
                break
        }
    }
}

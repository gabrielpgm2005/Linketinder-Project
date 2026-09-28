import { Candidato } from "../classes/Candidato.js";

export function registrarCandidato(): void {

    const formulario = document.getElementById(
        "candidatoForm"
    ) as HTMLFormElement;

    const nome = (document.getElementById("nomeCandidatoRegistro") as HTMLInputElement).value;

    const cpf = (document.getElementById("cpfCandidatoRegistro") as HTMLInputElement).value;

    const idade = Number(
        (document.getElementById("idadeCandidatoRegistro") as HTMLInputElement).value
    );

    const pais = (document.getElementById("paisCandidatoRegistro") as HTMLSelectElement).value;

    const cep = (document.getElementById("cepCandidatoRegistro") as HTMLInputElement).value;

    const descricao = (
        document.getElementById("descricaoCandidatoRegistro") as HTMLTextAreaElement
    ).value;

    const competencias = (
        document.getElementById("competenciasCandidatoRegistro") as HTMLInputElement
    ).value
        .split(",")
        .map(competencia => competencia.trim());

    const formacao = (
        document.getElementById("formacaoCandidatoRegistro") as HTMLInputElement
    ).value;

    const candidato = new Candidato(
        nome,
        cpf,
        idade,
        pais,
        cep,
        descricao,
        competencias,
        formacao
    );

    const candidatosSalvos = localStorage.getItem("candidatos");

    const candidatos: Candidato[] = candidatosSalvos
        ? JSON.parse(candidatosSalvos)
        : [];

    candidatos.push(candidato);

    localStorage.setItem(
        "candidatos",
        JSON.stringify(candidatos)
    );
    localStorage.setItem("usuarioLogado",JSON.stringify(candidato))
    formulario.reset();
    formulario.style.display = "none";
    window.location.href = "./perfilCandidato.html";
}
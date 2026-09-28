import { Candidato } from "../classes/Candidato.js";
export function registrarCandidato() {
    const formulario = document.getElementById("candidatoForm");
    const nome = document.getElementById("nomeCandidatoRegistro").value;
    const cpf = document.getElementById("cpfCandidatoRegistro").value;
    const idade = Number(document.getElementById("idadeCandidatoRegistro").value);
    const pais = document.getElementById("paisCandidatoRegistro").value;
    const cep = document.getElementById("cepCandidatoRegistro").value;
    const descricao = document.getElementById("descricaoCandidatoRegistro").value;
    const competencias = document.getElementById("competenciasCandidatoRegistro").value
        .split(",")
        .map(competencia => competencia.trim());
    const formacao = document.getElementById("formacaoCandidatoRegistro").value;
    const candidato = new Candidato(nome, cpf, idade, pais, cep, descricao, competencias, formacao);
    const candidatosSalvos = localStorage.getItem("candidatos");
    const candidatos = candidatosSalvos
        ? JSON.parse(candidatosSalvos)
        : [];
    candidatos.push(candidato);
    localStorage.setItem("candidatos", JSON.stringify(candidatos));
    localStorage.setItem("usuarioLogado", JSON.stringify(candidato));
    formulario.reset();
    formulario.style.display = "none";
    window.location.href = "./perfilCandidato.html";
}
//# sourceMappingURL=registrarCandidato.js.map
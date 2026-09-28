import { carregaCadastroCandidato } from "./trocaDePaginas/cadastroCandidato.js";
import { carregaCadastroEmpresa } from "./trocaDePaginas/cadastroEmpresa.js";
import { logarCandidato } from "./trocaDePaginas/logarCandidato.js";
import { logarEmpresa } from "./trocaDePaginas/logarEmpresa.js";
import { Candidato } from "./classes/Candidato.js";
import { Empresa } from "./classes/Empresa.js";
import { registrarCandidato } from "./trocaDePaginas/registrarCandidato.js";
import { registrarEmpresa } from "./trocaDePaginas/registrarEmpresa.js";
import { listarVagas } from "./funcionalidade/listarVagas.js";
import { removerCandidato } from "./funcionalidade/removerCandidato.js";
import { removerEmpresa } from "./funcionalidade/removerEmpresa.js";
import { listarCandidatos } from "./funcionalidade/listarCandidatos.js";
import { graficoCompetencias } from "./funcionalidade/plotarGraficoCompetencias.js";
let candidatos = JSON.parse(localStorage.getItem("candidatos")) || [];
let empresas = JSON.parse(localStorage.getItem("empresas")) || [];
document.getElementById("entrarCandidato")?.
    addEventListener("click", carregaCadastroCandidato);
document.getElementById("entrarEmpresa")?.
    addEventListener("click", carregaCadastroEmpresa);
document.getElementById("logarCandidato")?.
    addEventListener("click", (event) => {
    logarCandidato(event, candidatos);
});
document.getElementById("logarEmpresa")?.
    addEventListener("click", (event) => {
    logarEmpresa(event, empresas);
});
document.getElementById("salvarCandidato")?.
    addEventListener("click", registrarCandidato);
document.getElementById("salvarEmpresa")?.
    addEventListener("click", registrarEmpresa);
document.getElementById("listarVagas")?.
    addEventListener("click", listarVagas);
document.getElementById("deletarCandidato")?.
    addEventListener("click", removerCandidato);
document.getElementById("removerEmpresa")?.
    addEventListener("click", removerEmpresa);
document.getElementById("listarCandidatos")?.
    addEventListener("click", listarCandidatos);
document.getElementById("graficoCompetencias")?.
    addEventListener("click", graficoCompetencias);
//# sourceMappingURL=main.js.map
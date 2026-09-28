import { Candidato } from "../classes/Candidato.js";
export function logarCandidato(event, candidatos) {
    const input = document.getElementById("inputNomeCandidato");
    const nome = input.value;
    let candidato = candidatos.find(c => c.nome == nome);
    if (candidato === undefined) {
        alert("candidato não encontrado");
        return;
    }
    localStorage.setItem("usuarioLogado", JSON.stringify(candidato));
    window.location.href = "./perfilCandidato.html";
}
//# sourceMappingURL=logarCandidato.js.map
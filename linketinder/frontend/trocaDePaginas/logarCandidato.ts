import {Candidato} from "../classes/Candidato.js";

export function logarCandidato(event: Event,candidatos: Candidato[]): void {
    const input = document.getElementById("inputNomeCandidato") as HTMLInputElement;
    const nome = input.value;
    let candidato: Candidato | undefined = candidatos.find(c => c.nome == nome)
    if(candidato === undefined){
        alert("candidato não encontrado")
        return;
    }
    localStorage.setItem("usuarioLogado",JSON.stringify(candidato));
    window.location.href = "./perfilCandidato.html"
}
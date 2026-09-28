import type {Candidato} from "../classes/Candidato.js";

export function removerCandidato(event: Event) : void {
    const usuarioLogado: Candidato = JSON.parse(<string>localStorage.getItem("usuarioLogado"))
    const candidatos: Candidato[] = JSON.parse(<string>localStorage.getItem("candidatos"))
    const id : number = candidatos.findIndex( (candidato: Candidato) : boolean => {
        return candidato.nome === usuarioLogado.nome
    })
    if( id === -1){
        return;
    }
    candidatos.splice(id,1)
    localStorage.removeItem("usuarioLogado")
    localStorage.setItem("candidatos",JSON.stringify(candidatos))
    window.location.href = '../index.html'
}
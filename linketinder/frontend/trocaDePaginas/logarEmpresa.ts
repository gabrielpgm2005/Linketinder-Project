import {Empresa} from "../classes/Empresa.js";

export function logarEmpresa(event: Event,empresas: Empresa[]): void {
    const input = document.getElementById("inputNomeEmpresa") as HTMLInputElement;
    const nome = input.value;
    let empresa: Empresa | undefined = empresas.find(c => c.nome == nome)
    if(empresa === undefined){
        alert("Empresa não registrada!");
        return;
    }
    localStorage.setItem("usuarioLogado",JSON.stringify(empresa));
    window.location.href = "./perfilEmpresa.html"
}
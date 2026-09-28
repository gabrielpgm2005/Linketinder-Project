import { Empresa } from "../classes/Empresa.js";
export function logarEmpresa(event, empresas) {
    const input = document.getElementById("inputNomeEmpresa");
    const nome = input.value;
    let empresa = empresas.find(c => c.nome == nome);
    if (empresa === undefined) {
        alert("Empresa não registrada!");
        return;
    }
    localStorage.setItem("usuarioLogado", JSON.stringify(empresa));
    window.location.href = "./perfilEmpresa.html";
}
//# sourceMappingURL=logarEmpresa.js.map
import type { Empresa } from "../classes/Empresa.js";

export function removerEmpresa(event: Event): void {

    const empresaLogada: Empresa = JSON.parse(
        <string>localStorage.getItem("usuarioLogado")
    );

    const empresas: Empresa[] = JSON.parse(
        <string>localStorage.getItem("empresas")
    );

    const id: number = empresas.findIndex(
        (empresa: Empresa): boolean => {
            return empresa.nome === empresaLogada.nome;
        }
    );

    if (id === -1) {
        window.location.href = '../index.html'
        return;
    }

    empresas.splice(id, 1);

    localStorage.removeItem("usuarioLogado");

    localStorage.setItem(
        "empresas",
        JSON.stringify(empresas)
    );
    window.location.href = '../index.html'
}
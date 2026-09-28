export function removerEmpresa(event) {
    const empresaLogada = JSON.parse(localStorage.getItem("usuarioLogado"));
    const empresas = JSON.parse(localStorage.getItem("empresas"));
    const id = empresas.findIndex((empresa) => {
        return empresa.nome === empresaLogada.nome;
    });
    if (id === -1) {
        window.location.href = '../index.html';
        return;
    }
    empresas.splice(id, 1);
    localStorage.removeItem("usuarioLogado");
    localStorage.setItem("empresas", JSON.stringify(empresas));
    window.location.href = '../index.html';
}
//# sourceMappingURL=removerEmpresa.js.map
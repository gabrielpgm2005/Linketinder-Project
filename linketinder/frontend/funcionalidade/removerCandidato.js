export function removerCandidato(event) {
    const usuarioLogado = JSON.parse(localStorage.getItem("usuarioLogado"));
    const candidatos = JSON.parse(localStorage.getItem("candidatos"));
    const id = candidatos.findIndex((candidato) => {
        return candidato.nome === usuarioLogado.nome;
    });
    if (id === -1) {
        return;
    }
    candidatos.splice(id, 1);
    localStorage.removeItem("usuarioLogado");
    localStorage.setItem("candidatos", JSON.stringify(candidatos));
    window.location.href = '../index.html';
}
//# sourceMappingURL=removerCandidato.js.map
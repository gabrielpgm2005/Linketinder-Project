function calcularAfinidade(candidato, empresa) {
    if (empresa.competencias.length === 0) {
        return 0;
    }
    let competenciasPossuidas = 0;
    empresa.competencias.forEach((competenciaEmpresa) => {
        const possuiCompetencia = candidato.competencias.some((competenciaCandidato) => competenciaCandidato.toLowerCase().trim() ===
            competenciaEmpresa.toLowerCase().trim());
        if (possuiCompetencia) {
            competenciasPossuidas++;
        }
    });
    return (competenciasPossuidas /
        empresa.competencias.length) * 100;
}
export function listarVagas(event) {
    const tabela = document.getElementById("tableVagas");
    const usuarioLogado = JSON.parse(localStorage.getItem("usuarioLogado"));
    const empresas = JSON.parse(localStorage.getItem("empresas"));
    empresas.forEach((empresa) => {
        const afinidade = calcularAfinidade(usuarioLogado, empresa);
        empresa.competencias.forEach((competencia) => {
            const linha = tabela.insertRow();
            const nomeVaga = linha.insertCell();
            const indiceAfinidade = linha.insertCell();
            nomeVaga.textContent = competencia;
            indiceAfinidade.textContent =
                `${afinidade.toFixed(2)}%`;
        });
    });
    tabela.style.display = "table";
}
//# sourceMappingURL=listarVagas.js.map
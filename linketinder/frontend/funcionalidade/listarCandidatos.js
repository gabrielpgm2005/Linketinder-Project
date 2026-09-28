export function listarCandidatos() {
    const lista = document.getElementById("listaCandidatos");
    const candidatos = JSON.parse(localStorage.getItem("candidatos"));
    candidatos.forEach((candidato) => {
        const candidatoDiv = document.createElement("div");
        const formacao = document.createElement("p");
        formacao.textContent =
            `Formação: ${candidato.formacao}`;
        const competencias = document.createElement("ul");
        candidato.competencias.forEach((competencia) => {
            const item = document.createElement("li");
            item.textContent = competencia;
            competencias.appendChild(item);
        });
        candidatoDiv.appendChild(formacao);
        candidatoDiv.appendChild(competencias);
        lista.appendChild(candidatoDiv);
    });
}
//# sourceMappingURL=listarCandidatos.js.map
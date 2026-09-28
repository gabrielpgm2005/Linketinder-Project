let grafico = null;
export function graficoCompetencias() {
    const canvas = document.getElementById("grafico");
    const candidatos = JSON.parse(localStorage.getItem("candidatos"));
    const quantidadeCompetencias = {};
    candidatos.forEach((candidato) => {
        candidato.competencias.forEach((competencia) => {
            const nomeCompetencia = competencia.toLowerCase().trim();
            if (quantidadeCompetencias[nomeCompetencia] === undefined) {
                quantidadeCompetencias[nomeCompetencia] = 1;
            }
            else {
                quantidadeCompetencias[nomeCompetencia]++;
            }
        });
    });
    const competencias = Object.keys(quantidadeCompetencias);
    const quantidades = Object.values(quantidadeCompetencias);
    if (grafico !== null) {
        grafico.destroy();
    }
    grafico = new Chart(canvas, {
        type: "bar",
        data: {
            labels: competencias,
            datasets: [
                {
                    label: "Número de candidatos",
                    data: quantidades
                }
            ]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}
//# sourceMappingURL=plotarGraficoCompetencias.js.map
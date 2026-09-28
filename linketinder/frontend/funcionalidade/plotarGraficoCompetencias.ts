import type { Candidato } from "../classes/Candidato.js";

let grafico: Chart | null = null;

export function graficoCompetencias(): void {

    const canvas = document.getElementById(
        "grafico"
    ) as HTMLCanvasElement;

    const candidatos: Candidato[] = JSON.parse(
        <string>localStorage.getItem("candidatos")
    );

    const quantidadeCompetencias: { [competencia: string]: number } = {};

    candidatos.forEach(
        (candidato: Candidato): void => {

            candidato.competencias.forEach(
                (competencia: string): void => {

                    const nomeCompetencia =
                        competencia.toLowerCase().trim();

                    if (quantidadeCompetencias[nomeCompetencia] === undefined) {
                        quantidadeCompetencias[nomeCompetencia] = 1;
                    } else {
                        quantidadeCompetencias[nomeCompetencia]++;
                    }
                }
            );
        }
    );

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
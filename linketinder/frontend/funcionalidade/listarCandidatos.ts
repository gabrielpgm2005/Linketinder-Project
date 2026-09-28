import type { Candidato } from "../classes/Candidato.js";

export function listarCandidatos(): void {

    const lista = document.getElementById(
        "listaCandidatos"
    ) as HTMLDivElement;

    const candidatos: Candidato[] = JSON.parse(
        <string>localStorage.getItem("candidatos")
    );

    candidatos.forEach(
        (candidato: Candidato): void => {

            const candidatoDiv = document.createElement("div");

            const formacao = document.createElement("p");
            formacao.textContent =
                `Formação: ${candidato.formacao}`;

            const competencias = document.createElement("ul");

            candidato.competencias.forEach(
                (competencia: string): void => {

                    const item = document.createElement("li");
                    item.textContent = competencia;

                    competencias.appendChild(item);
                }
            );
            candidatoDiv.appendChild(formacao);
            candidatoDiv.appendChild(competencias);

            lista.appendChild(candidatoDiv);
        }
    );
}
import type { Candidato } from "../classes/Candidato.js";
import type { Empresa } from "../classes/Empresa.js";


function calcularAfinidade(
    candidato: Candidato,
    empresa: Empresa
): number {

    if (empresa.competencias.length === 0) {
        return 0;
    }

    let competenciasPossuidas = 0;

    empresa.competencias.forEach(
        (competenciaEmpresa: string): void => {

            const possuiCompetencia =
                candidato.competencias.some(
                    (competenciaCandidato: string): boolean =>
                        competenciaCandidato.toLowerCase().trim() ===
                        competenciaEmpresa.toLowerCase().trim()
                );

            if (possuiCompetencia) {
                competenciasPossuidas++;
            }
        }
    );

    return (
        competenciasPossuidas /
        empresa.competencias.length
    ) * 100;
}


export function listarVagas(event: Event): void {

    const tabela = document.getElementById(
        "tableVagas"
    ) as HTMLTableElement;

    const usuarioLogado: Candidato = JSON.parse(
        <string>localStorage.getItem("usuarioLogado")
    );

    const empresas: Empresa[] = JSON.parse(
        <string>localStorage.getItem("empresas")
    );

    empresas.forEach(
        (empresa: Empresa): void => {

            const afinidade = calcularAfinidade(
                usuarioLogado,
                empresa
            );

            empresa.competencias.forEach(
                (competencia: string): void => {

                    const linha = tabela.insertRow();

                    const nomeVaga = linha.insertCell();
                    const indiceAfinidade = linha.insertCell();

                    nomeVaga.textContent = competencia;

                    indiceAfinidade.textContent =
                        `${afinidade.toFixed(2)}%`;
                }
            );
        }
    );

    tabela.style.display = "table";
}
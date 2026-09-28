import { Empresa } from "../classes/Empresa.js";

export function registrarEmpresa(): void {

    const formulario = document.getElementById(
        "empresaForm"
    ) as HTMLFormElement;

    const nome = (
        document.getElementById("nomeEmpresaRegistro") as HTMLInputElement
    ).value;

    const email = (
        document.getElementById("emailEmpresaRegistro") as HTMLInputElement
    ).value;

    const cnpj = (
        document.getElementById("cnpjEmpresaRegistro") as HTMLInputElement
    ).value;

    const pais = (
        document.getElementById("paisEmpresaRegistro") as HTMLSelectElement
    ).value;

    const estado = (
        document.getElementById("estadoEmpresaRegistro") as HTMLSelectElement
    ).value;

    const cep = (
        document.getElementById("cepEmpresaRegistro") as HTMLInputElement
    ).value;

    const descricao = (
        document.getElementById("descricaoEmpresaRegistro") as HTMLTextAreaElement
    ).value;

    const competencias = (
        document.getElementById("competenciasEmpresaRegistro") as HTMLInputElement
    ).value
        .split(",")
        .map(competencia => competencia.trim());


    const empresa = new Empresa(
        nome,
        email,
        cnpj,
        pais,
        estado,
        cep,
        descricao,
        competencias
    );


    const empresasSalvas = localStorage.getItem("empresas");

    const empresas: Empresa[] = empresasSalvas
        ? JSON.parse(empresasSalvas)
        : [];


    empresas.push(empresa);


    localStorage.setItem(
        "empresas",
        JSON.stringify(empresas)
    );
    localStorage.setItem("usuarioLogado",JSON.stringify(empresa))


    formulario.reset();

    formulario.style.display = "none";


    window.location.href = "./perfilEmpresa.html";
}
import { Empresa } from "../classes/Empresa.js";
export function registrarEmpresa() {
    const formulario = document.getElementById("empresaForm");
    const nome = document.getElementById("nomeEmpresaRegistro").value;
    const email = document.getElementById("emailEmpresaRegistro").value;
    const cnpj = document.getElementById("cnpjEmpresaRegistro").value;
    const pais = document.getElementById("paisEmpresaRegistro").value;
    const estado = document.getElementById("estadoEmpresaRegistro").value;
    const cep = document.getElementById("cepEmpresaRegistro").value;
    const descricao = document.getElementById("descricaoEmpresaRegistro").value;
    const competencias = document.getElementById("competenciasEmpresaRegistro").value
        .split(",")
        .map(competencia => competencia.trim());
    const empresa = new Empresa(nome, email, cnpj, pais, estado, cep, descricao, competencias);
    const empresasSalvas = localStorage.getItem("empresas");
    const empresas = empresasSalvas
        ? JSON.parse(empresasSalvas)
        : [];
    empresas.push(empresa);
    localStorage.setItem("empresas", JSON.stringify(empresas));
    localStorage.setItem("usuarioLogado", JSON.stringify(empresa));
    formulario.reset();
    formulario.style.display = "none";
    window.location.href = "./perfilEmpresa.html";
}
//# sourceMappingURL=registrarEmpresa.js.map
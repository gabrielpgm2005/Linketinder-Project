package org.example.dao

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.example.model.Empresa

class SqlEmpresaDAO implements EmpresaDAO{

    Sql sql = Sql.newInstance(
            url: 'jdbc:postgresql://localhost:5432/linketinder',
            user: 'postgres',
            password: '123456',
            driver: 'org.postgresql.Driver'
    )
    @Override
    List<Empresa> getAllEmpresas() {
        sql.rows("SELECT * FROM public.dados_empresas").collect({row ->
            Empresa empresa = new Empresa()
            empresa.setId(row.id_empresa)
            empresa.setNome(row.nome)
            empresa.setCnpj(row.cnpj)
            empresa.setEmail(row.email)
            empresa.setDescricao(row.descricao)
            empresa.setPais(row.pais)
            empresa.setCep(row.cep)
            empresa.setSenha(row.senha)
            empresa
        })
    }

    @Override
    Empresa findEmpresaById(int id) {

        def row = sql.firstRow("""
        SELECT *
        FROM dados_empresas
        WHERE id_empresa = ?
    """, id)

        Empresa empresa = new Empresa()

        empresa.setId(row.id_empresa)
        empresa.setNome(row.nome)
        empresa.setEmail(row.email)
        empresa.setCnpj(row.cnpj)
        empresa.setPais(row.pais)
        empresa.setCep(row.cep)
        empresa.setDescricao(row.descricao)
        empresa.setSenha(row.senha)

        empresa
    }

    @Override
    void insertEmpresa(Empresa empresa) {
        def params = [
                empresa.getNome(),
                empresa.getCnpj(),
                empresa.getEmail(),
                empresa.getDescricao(),
                empresa.getPais(),
                empresa.getCep(),
                empresa.getSenha()
        ]

        sql.execute("""
            INSERT INTO public.dados_empresas (nome, cnpj, email, descricao, pais, cep, senha)
            VALUES (?,?,?,?,?,?,?)
        """,params)
    }

    @Override
    void deleteEmpresa(int id) {
        sql.execute("DELETE FROM public.dados_empresas WHERE id_empresa=?",id)
    }

    void updateEmpresa(Empresa empresa) {
        def params = [
                empresa.getNome(),
                empresa.getCnpj(),
                empresa.getEmail(),
                empresa.getDescricao(),
                empresa.getPais(),
                empresa.getCep(),
                empresa.getSenha(),
                empresa.getId()
        ]

        sql.execute("""
        UPDATE dados_empresas
        SET nome = ?,
            cnpj = ?,
            email = ?,
            descricao = ?,
            pais = ?,
            cep = ?,
            senha = ?
        WHERE id_empresa = ?
    """, params)
    }
}

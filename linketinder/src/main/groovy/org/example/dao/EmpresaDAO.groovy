package org.example.dao

import org.example.model.Candidato
import org.example.model.Empresa

interface EmpresaDAO {
    List<Empresa> getAllEmpresas();
    Empresa findEmpresaById(int id);
    void insertEmpresa(Empresa empresa);
    void deleteEmpresa(int id);
    void updateEmpresa(Empresa empresa);
    void salvarCurtidaDaEmpresa(Empresa empresa, Candidato candidato, CurtidaDAO curtidaDB)
}
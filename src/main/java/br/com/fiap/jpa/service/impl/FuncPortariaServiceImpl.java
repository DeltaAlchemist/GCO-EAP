package br.com.fiap.jpa.service.impl;

import br.com.fiap.jpa.dao.impl.FuncPortariaDAOImpl;
import br.com.fiap.jpa.entity.FuncPortaria;
import br.com.fiap.jpa.service.GenericService;

import java.util.List;

public class FuncPortariaServiceImpl extends GenericService<FuncPortaria, Long> {

    private static FuncPortariaServiceImpl instance = null;

    private FuncPortariaDAOImpl funcPortariaDAO;


    private FuncPortariaServiceImpl() {
        funcPortariaDAO = FuncPortariaDAOImpl.getInstance();
    }

    public static FuncPortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new FuncPortariaServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(FuncPortaria funcPortaria) {
        try {
            funcPortariaDAO.salvar(funcPortaria, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(FuncPortaria funcPortaria) {
        try {
            funcPortariaDAO.atualizar(funcPortaria, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            funcPortariaDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public FuncPortaria obter(Long id) {
        FuncPortaria funcPortaria = null;

        try {
            funcPortaria = funcPortariaDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return funcPortaria;
    }

    @Override
    public List<FuncPortaria> listar() {
        List<FuncPortaria> funcionarios = null;

        try {
            funcionarios = funcPortariaDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return funcionarios;
    }
}

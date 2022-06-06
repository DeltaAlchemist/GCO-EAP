package br.com.fiap.jpa.service.impl;

import br.com.fiap.jpa.dao.impl.CondominioDAOImpl;
import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.service.GenericService;

import java.util.List;

public class CondominioServiceImpl extends GenericService<Condominio, Long> {

    private static CondominioServiceImpl instance = null;

    private CondominioDAOImpl condominioDAO;


    private CondominioServiceImpl() {
        condominioDAO = CondominioDAOImpl.getInstance();
    }

    public static CondominioServiceImpl getInstance() {

        if (instance == null) {
            instance = new CondominioServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Condominio condominio) {
        try {
            condominioDAO.salvar(condominio, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Condominio condominio) {
        try {
            condominioDAO.atualizar(condominio, getEntityManager());
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public void remover(Long id) {
        try {
            condominioDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    @Override
    public Condominio obter(Long id) {
        Condominio condominio = null;

        try {
            condominio = condominioDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return condominio;
    }

    @Override
    public List<Condominio> listar() {
        List<Condominio> condominios = null;

        try {
            condominios = condominioDAO.listar(getEntityManager());
        } catch (Exception e) {
        } finally {
            closeEntityManager();
        }

        return condominios;
    }
}

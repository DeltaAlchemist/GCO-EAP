package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDAOImpl extends HibernateGenericDAO<Movimentacao, Long> {

    private static MovimentacaoDAOImpl instance = null;

    public static MovimentacaoDAOImpl getInstance() {
        if (instance == null) {
            instance = new MovimentacaoDAOImpl();
        }

        return instance;
    }

    private MovimentacaoDAOImpl() {
        super(Movimentacao.class);
    }

    public List<Movimentacao> listarPorTipo(String tipo, EntityManager entityManager) {
        String jpql = "SELECT a FROM Movimentacao a WHERE a.movimentacao = :tipo";

        TypedQuery<Movimentacao> consulta = entityManager.createQuery(jpql, Movimentacao.class);
        consulta.setParameter("tipo", tipo);

        return consulta.getResultList();
    }

}

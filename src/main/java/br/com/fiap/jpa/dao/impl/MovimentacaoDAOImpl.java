package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Movimentacao;

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

}

package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Visitante;

public class VisitanteDAOImpl extends HibernateGenericDAO<Visitante, Long> {

    private static VisitanteDAOImpl instance = null;

    public static VisitanteDAOImpl getInstance() {
        if (instance == null) {
            instance = new VisitanteDAOImpl();
        }

        return instance;
    }

    private VisitanteDAOImpl() {
        super(Visitante.class);
    }

}

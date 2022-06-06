package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Portaria;

public class PortariaDAOImpl extends HibernateGenericDAO<Portaria, Long> {

    private static PortariaDAOImpl instance = null;

    public static PortariaDAOImpl getInstance() {
        if (instance == null) {
            instance = new PortariaDAOImpl();
        }
        return instance;
    }

    private PortariaDAOImpl() {
        super(Portaria.class);
    }

}

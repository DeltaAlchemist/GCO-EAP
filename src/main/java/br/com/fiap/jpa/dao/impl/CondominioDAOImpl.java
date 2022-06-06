package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Condominio;

public class CondominioDAOImpl extends HibernateGenericDAO<Condominio, Long> {

    private static CondominioDAOImpl instance = null;

    public static CondominioDAOImpl getInstance() {
        if (instance == null) {
            instance = new CondominioDAOImpl();
        }

        return instance;
    }

    private CondominioDAOImpl() {
        super(Condominio.class);
    }

}
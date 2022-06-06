package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.FuncPortaria;

public class FuncPortariaDAOImpl extends HibernateGenericDAO<FuncPortaria, Long> {

    private static FuncPortariaDAOImpl instance = null;

    public static FuncPortariaDAOImpl getInstance() {
        if (instance == null) {
            instance = new FuncPortariaDAOImpl();
        }

        return instance;
    }

    private FuncPortariaDAOImpl() {
        super(FuncPortaria.class);
    }

}

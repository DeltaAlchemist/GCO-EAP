package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Visitante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Visitante> pesquisar(String nome, String cpf, LocalDate dataCadastro,
                                     EntityManager entityManager) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);

        Root<Visitante> participante = criteriaQuery.from(Visitante.class);

        List<Predicate> predicates = new ArrayList<>();

        if (nome != null) {
            Predicate predicate = builder.like(
                    builder.upper(participante.get("nome")), "%" + nome.toUpperCase() + "%");
            predicates.add(predicate);
        }

        if (cpf != null) {
            Predicate predicate = builder.equal(participante.get("cpf"), cpf);
            predicates.add(predicate);
        }

        if (dataCadastro != null) {
            Predicate predicate = builder.greaterThanOrEqualTo(
                    participante.get("dataCadastro"), dataCadastro);
            predicates.add(predicate);
        }

        criteriaQuery.select(participante);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);

        return consulta.getResultList();
    }

}

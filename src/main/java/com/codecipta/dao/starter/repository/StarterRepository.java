package com.codecipta.dao.starter.repository;

import com.codecipta.dao.starter.entity.StarterEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class StarterRepository {
    @Inject
    EntityManager entityManager;

    public List<StarterEntity> GetAllData() {
        Query query = entityManager.createNamedQuery("Feature.QueryName");

        return query.getResultList();
    }
}

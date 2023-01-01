package com.example.basic.repository;

import com.example.basic.domain.entity.Coffee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CoffeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Coffee save(Coffee coffee){
        entityManager.persist(coffee);
        return coffee;
    }

}

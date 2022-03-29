package ru.netology.springdb.repository;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductsRepository {

    @PersistenceContext
    EntityManager enterpriseDispatcher;

    public List<String> getProductName(String customersName) {
        return enterpriseDispatcher
                .createQuery(
                        "select o.productName from Order o where o.customerId.name = :name",
                        String.class)
                .setParameter("name", customersName)
                .getResultList();
    }


}

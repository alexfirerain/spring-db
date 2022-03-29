package ru.netology.springdb.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.springdb.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductsRepository {
    private static final String productByNameRequest = read("productByNameRequest.sql");

    @PersistenceContext
    EntityManager enterpriseDispatcher;

    public List<String> getProductName(String customersName) {
        return enterpriseDispatcher
                .createQuery(
                        "select o from Order o inner join fetch Customer c where c.name = :name",
                        Order.class)
                .setParameter("name", customersName)
                .getResultList().stream().map(Order::getProductName).collect(Collectors.toList());
    }


//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public List<String> getProductName(String customersName) {
//        return namedParameterJdbcTemplate.queryForList(productByNameRequest,
//                Map.of("name", customersName),
//                String.class);
//    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

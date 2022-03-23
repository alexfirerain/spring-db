package ru.netology.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springdb.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<String> getProductName(String customersName) {
        return productsRepository.getProductName(customersName);
    }

}

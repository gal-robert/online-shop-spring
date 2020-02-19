package com.galrobert.onlineshop.service;

import com.galrobert.onlineshop.domain.Product;
import com.galrobert.onlineshop.persistance.ProductRepository;
import com.galrobert.onlineshop.transfer.SaveProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    //logging
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    //inversion of control (IoC)
    private final ProductRepository productRepository;

    //Dependency Injection (from IoC Container)
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest req) {
        LOGGER.info("Creating product {}", req);
        Product product = new Product();

        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setImageUrl(req.getImageUrl());
        product.setPrice(req.getPrice());
        product.setQuantity(req.getQuantity());

        return productRepository.save(product);
    }
}

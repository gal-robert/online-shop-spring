package com.galrobert.onlineshop.persistance;

import com.galrobert.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

package com.example.task1.repository;

import com.example.task1.entity.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

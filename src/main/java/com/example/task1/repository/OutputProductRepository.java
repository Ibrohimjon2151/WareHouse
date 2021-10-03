package com.example.task1.repository;

import com.example.task1.entity.OutputProduct;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}

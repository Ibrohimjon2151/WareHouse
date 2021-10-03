package com.example.task1.repository;

import com.example.task1.entity.InputProduct;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}

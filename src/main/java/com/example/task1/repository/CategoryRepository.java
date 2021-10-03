package com.example.task1.repository;

import com.example.task1.entity.Category;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

package com.example.task1.repository;

import com.example.task1.entity.Input;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Integer> {
}

package com.example.task1.repository;

import com.example.task1.entity.Output;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputRepository extends JpaRepository<Output, Integer> {
}

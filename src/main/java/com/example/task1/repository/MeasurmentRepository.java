package com.example.task1.repository;

import com.example.task1.entity.Measurment;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurmentRepository extends JpaRepository<Measurment, Integer> {
}

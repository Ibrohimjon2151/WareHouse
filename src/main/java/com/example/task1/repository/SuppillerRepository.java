package com.example.task1.repository;

import com.example.task1.entity.Suppiller;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppillerRepository extends JpaRepository<Suppiller, Integer> {
}

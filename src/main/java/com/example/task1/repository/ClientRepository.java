package com.example.task1.repository;

import com.example.task1.entity.Client;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

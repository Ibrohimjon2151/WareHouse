package com.example.task1.repository;

import com.example.task1.entity.WareHouse;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse, Integer> {
}

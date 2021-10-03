package com.example.task1.repository;

import com.example.task1.entity.Currency;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}

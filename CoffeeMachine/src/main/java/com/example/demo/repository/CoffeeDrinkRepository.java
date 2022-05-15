package com.example.demo.repository;

import com.example.demo.model.CoffeeDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeDrinkRepository extends JpaRepository<CoffeeDrink, Long> {
}

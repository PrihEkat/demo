package com.example.demo.service;

import com.example.demo.model.CoffeeDrink;
import com.example.demo.repository.CoffeeDrinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoffeeDrinkService implements CommonService<CoffeeDrink> {

    private final CoffeeDrinkRepository repository;

    @Override
    public List<CoffeeDrink> readAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(CoffeeDrink coffeeDrink) {
        repository.save(coffeeDrink);
    }

    @Override
    public void update(CoffeeDrink coffeeDrink) {
        repository.saveAndFlush(coffeeDrink);
    }

    @Override
    public boolean search(Long id) {
        return repository.existsById(id);
    }

    @Override
    public CoffeeDrink getById(Long id) {
        return repository.getById(id);
    }
}

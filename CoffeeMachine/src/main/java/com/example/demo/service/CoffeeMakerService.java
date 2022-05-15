package com.example.demo.service;

import com.example.demo.model.CoffeeMaker;
import com.example.demo.repository.CoffeeMakerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoffeeMakerService implements CommonService<CoffeeMaker> {

    private final CoffeeMakerRepository repository;

    @Override
    public List<CoffeeMaker> readAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(CoffeeMaker coffeeMaker) {
        repository.save(coffeeMaker);
    }

    @Override
    public void update(CoffeeMaker coffeeMaker) {
        repository.saveAndFlush(coffeeMaker);
    }

    @Override
    public boolean search(Long id) {
        return repository.existsById(id);
    }

    @Override
    public CoffeeMaker getById(Long id) {
        return repository.getById(id);
    }
}

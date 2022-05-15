package com.example.demo.controller;

import com.example.demo.model.CoffeeMaker;
import com.example.demo.service.CoffeeMakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/demo.example.com/coffee_maker")
public class CoffeeMakerController implements CommonController<CoffeeMaker> {

    private final CoffeeMakerService service;

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        if (service.search(id)) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Void> create(CoffeeMaker coffeeMaker) {
        service.create(coffeeMaker);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<CoffeeMaker>> getAll() {
        List<CoffeeMaker> coffeeMakers = service.readAll();
        return new ResponseEntity<>(coffeeMakers, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CoffeeMaker> getById(Long id) {
        CoffeeMaker coffeeMaker = service.getById(id);
        return new ResponseEntity<>(coffeeMaker, HttpStatus.OK);
    }
}

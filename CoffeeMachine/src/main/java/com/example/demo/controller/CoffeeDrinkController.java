package com.example.demo.controller;

import com.example.demo.model.CoffeeDrink;
import com.example.demo.service.CoffeeDrinkService;
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
@RequestMapping("/demo.example.com/coffee_drink")
public class CoffeeDrinkController implements CommonController<CoffeeDrink> {

    private final CoffeeDrinkService service;

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
    public ResponseEntity<Void> create(CoffeeDrink coffeeDrink) {
        service.create(coffeeDrink);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<CoffeeDrink>> getAll() {
        List<CoffeeDrink> coffeeDrinks = service.readAll();
        return new ResponseEntity<>(coffeeDrinks, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CoffeeDrink> getById(Long id) {
        CoffeeDrink coffeeDrink = service.getById(id);
        return new ResponseEntity<>(coffeeDrink, HttpStatus.OK);
    }
}

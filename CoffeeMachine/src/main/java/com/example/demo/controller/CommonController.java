package com.example.demo.controller;

import com.example.demo.model.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {
    ResponseEntity<Void> deleteById(Long id);

    ResponseEntity<Void> create(E e);

    ResponseEntity<List<E>> getAll();

    ResponseEntity<E> getById(Long id);
}
package com.example.demo.service;

import com.example.demo.model.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {
    List<E> readAll();

    void deleteById(Long id);

    void create(E e);

    void update(E e);

    boolean search(Long id);

    E getById(Long id);
}

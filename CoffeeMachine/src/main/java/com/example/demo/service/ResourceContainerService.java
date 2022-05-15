package com.example.demo.service;

import com.example.demo.model.ResourceContainer;
import com.example.demo.repository.ResourceContainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResourceContainerService implements CommonService<ResourceContainer> {

    private final ResourceContainerRepository repository;

    @Override
    public List<ResourceContainer> readAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(ResourceContainer resourceContainer) {
        repository.save(resourceContainer);
    }

    @Override
    public void update(ResourceContainer resourceContainer) {
        repository.saveAndFlush(resourceContainer);
    }

    @Override
    public boolean search(Long id) {
        return repository.existsById(id);
    }

    @Override
    public ResourceContainer getById(Long id) {
        return repository.getById(id);
    }
}

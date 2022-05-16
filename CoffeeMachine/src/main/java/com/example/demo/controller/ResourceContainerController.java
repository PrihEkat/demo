package com.example.demo.controller;

import com.example.demo.model.ResourceContainer;
import com.example.demo.service.ResourceContainerService;
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
@RequestMapping("/demo.example.com/resource_container")
public class ResourceContainerController implements CommonController<ResourceContainer> {

    private final ResourceContainerService service;

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
    public ResponseEntity<Void> create(ResourceContainer resourceContainer) {
        service.create(resourceContainer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ResourceContainer>> getAll() {
        List<ResourceContainer> resourceContainers = service.readAll();
        return new ResponseEntity<>(resourceContainers, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResourceContainer> getById(Long id) {
        ResourceContainer resourceContainer = service.getById(id);
        return new ResponseEntity<>(resourceContainer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getResource(ResourceContainer resourceContainer) {
        final Long resourceContainerId = resourceContainer.getId();
        if (!service.search(resourceContainerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        final ResourceContainer resourceContainerDb = service.getById(resourceContainerId);
        final boolean f = resourceContainerDb.getWeight() > resourceContainer.getWeight();
        if (resourceContainerDb.getWeight() > resourceContainer.getWeight()) {
            service.recalculate(resourceContainer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

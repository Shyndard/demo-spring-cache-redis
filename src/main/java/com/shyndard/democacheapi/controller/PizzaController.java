package com.shyndard.democacheapi.controller;

import java.util.Collection;
import java.util.UUID;

import com.shyndard.democacheapi.entity.Pizza;
import com.shyndard.democacheapi.service.PizzaService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(final PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    // Get all pizzas entries
    @GetMapping
    @Cacheable(value = "pizza")
    public Collection<Pizza> getAll() {
        return pizzaService.getAllPizza();
    }

    // Get pizza entry by id
    @GetMapping("{id}")
    // Add in cache matching response based on id
    // Do not save null result in cache 
    @Cacheable(value = "pizza", key = "#id", unless = "#result == null")
    public Pizza getById(@PathVariable(name = "id") final UUID id) {
        return pizzaService.getPizzaById(id);
    }

    // Create a new pizza entry
    @PostMapping
    // Add new entry in cache based with result's id
    // Do not save in cache null result
    @CachePut(value = "pizza", key = "#result.id", unless = "#result == null")
    public Pizza create(@RequestBody final String name) {
        return pizzaService.createPizza(name);
    }

    // Update an already existing pizza entry
    @PutMapping("{id}")
    // Only update cache with entry matching id
    // Do not save in cache null result
    @CachePut(value = "pizza", key = "#id", unless = "#result == null")
    public Pizza updateById(@PathVariable(name = "id") final UUID id, @RequestBody final String name) {
        return pizzaService.updatePizza(id, name);
    }

    // Remove an existing pizza entry
    @DeleteMapping("{id}")
    // Remove entry from cache with matching id
    @CacheEvict(value = "pizza", key = "#id")
    public void deleteById(@PathVariable(name = "id") final UUID id) {
        pizzaService.deletePizzaById(id);
    }
}

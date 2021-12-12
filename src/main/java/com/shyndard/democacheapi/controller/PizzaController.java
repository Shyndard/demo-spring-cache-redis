package com.shyndard.democacheapi.controller;

import java.util.Collection;
import java.util.UUID;

import com.shyndard.democacheapi.entity.Pizza;
import com.shyndard.democacheapi.service.PizzaService;

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

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public Collection<Pizza> getAll() {
        return pizzaService.getAllPizza();
    }

    @GetMapping("{id}")
    public Pizza getById(@PathVariable(name = "id") final UUID id) {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping
    public Pizza create(@RequestBody final String name) {
        return pizzaService.createPizza(name);
    }

    @PutMapping("{id}")
    public Pizza updateById(@PathVariable(name = "id") final UUID id, @RequestBody final String name) {
        return pizzaService.updatePizza(id, name);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") final UUID id) {
        pizzaService.deletePizzaById(id);
    }
}

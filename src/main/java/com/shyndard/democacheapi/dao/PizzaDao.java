package com.shyndard.democacheapi.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.shyndard.democacheapi.entity.Pizza;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class PizzaDao {

    private final Map<UUID, Pizza> pizzas = new HashMap<>();

    public Collection<Pizza> getAllPizza() {
        return pizzas.values();
    }

    public Pizza getPizzaById(UUID id) {
        if (pizzas.containsKey(id)) {
            return pizzas.get(id);
        }
        System.out.println("throw not found");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Pizza createPizza(String name) {
        Pizza pizza = new Pizza(UUID.randomUUID(), name);
        return pizzas.put(pizza.getId(), pizza);
    }

    public Pizza updatePizza(UUID id, String name) {
        if (pizzas.containsKey(id)) {
            return pizzas.put(id, pizzas.get(id).setName(name));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deletePizzaById(UUID id) {
        if (pizzas.containsKey(id)) {
            pizzas.remove(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}

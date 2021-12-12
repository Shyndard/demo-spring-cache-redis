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
        sleep("getAll");
        return pizzas.values();
    }

    public Pizza getPizzaById(final UUID id) {
        sleep("getById");
        if (pizzas.containsKey(id)) {
            return pizzas.get(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza not found");
    }

    public Pizza createPizza(final String name) {
        sleep("create");
        Pizza pizza = new Pizza(UUID.randomUUID(), name);
        pizzas.put(pizza.getId(), pizza);
        return pizza;
    }

    public Pizza updatePizza(final UUID id, final String name) {
        sleep("update");
        if (pizzas.containsKey(id)) {
            return pizzas.put(id, pizzas.get(id).setName(name));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza not found");
    }

    public void deletePizzaById(final UUID id) {
        sleep("delete");
        if (pizzas.containsKey(id)) {
            pizzas.remove(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza not found");
    }

    private void sleep(final String action) {
        try {
            System.out.println(action + " > Sleep for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

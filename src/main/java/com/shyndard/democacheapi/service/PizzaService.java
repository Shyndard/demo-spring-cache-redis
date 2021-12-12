package com.shyndard.democacheapi.service;

import java.util.UUID;

import com.shyndard.democacheapi.dao.PizzaDao;
import com.shyndard.democacheapi.entity.Pizza;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private final PizzaDao pizzaDao;

    public PizzaService(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public Pizza getPizzaById(UUID id) {
        return pizzaDao.getPizzaById(id);
    }

    public Pizza createPizza(String name) {
        return pizzaDao.createPizza(name);
    }

    public Pizza updatePizza(UUID id, String name) {
        return pizzaDao.updatePizza(id, name);
    }

    public void deletePizzaById(UUID id) {
        pizzaDao.deletePizzaById(id);
    }
}

package com.shyndard.democacheapi.entity;

import java.util.UUID;

public class Pizza {

    private UUID id;
    private String name;

    public Pizza() {

    }

    public Pizza(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Pizza setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pizza setName(String name) {
        this.name = name;
        return this;
    }

}

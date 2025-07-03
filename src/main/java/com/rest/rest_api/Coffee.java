package com.rest.rest_api;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coffee {
    private String name;
    
    @Id
    private String id;

    // Required no-arg constructor
    public Coffee() {
    }

    public Coffee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Coffee(String name) {
        this(name, UUID.randomUUID().toString());
    }

    // Proper JavaBean setter
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
package com.softserve.edu.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Entity {
    private int id;
    private String name;

    private static int counter;

    public Entity(String name) {
        this.id = counter++;
        this.name = name;
    }
}

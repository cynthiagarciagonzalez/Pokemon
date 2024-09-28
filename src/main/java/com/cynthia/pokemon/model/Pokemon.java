package com.cynthia.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pokemon {
    private String name;
    private int weight;
    private int height;
    @JsonProperty("base_experience")
    private int baseExperience;

    public Pokemon() {}

    public Pokemon(String name, int weight, int height, int baseExperience) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.baseExperience = baseExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return weight == pokemon.weight && height == pokemon.height && baseExperience == pokemon.baseExperience && Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, height, baseExperience);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", baseExperience=" + baseExperience +
                '}';
    }
}
package com.cynthia.pokemon.model;

import java.util.Objects;

public class Result {

    private String name;
    private String url;

    public Result() {
    }

    public Result(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return Objects.equals(name, that.name) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "PokemonSummary{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

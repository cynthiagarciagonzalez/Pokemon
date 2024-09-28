package com.cynthia.pokemon.controller;

import com.cynthia.pokemon.model.Pokemon;
import com.cynthia.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/heaviest")
    public List<Pokemon> getHeaviestPokemon() {
        return pokemonService.getHeaviestPokemon();
    }

    @GetMapping("/tallest")
    public List<Pokemon> getTallestPokemon() {
        return pokemonService.getTallestPokemon();
    }

    @GetMapping("/experienced")
    public List<Pokemon> getExperiencedPokemon() {
        return pokemonService.getExperiencedPokemon();
    }
}
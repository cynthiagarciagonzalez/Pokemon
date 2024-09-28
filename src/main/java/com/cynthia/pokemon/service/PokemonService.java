package com.cynthia.pokemon.service;

import com.cynthia.pokemon.model.Pokemon;
import com.cynthia.pokemon.model.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Pokemon> getHeaviestPokemon() {
        return getAllPokemon().stream()
                .sorted(Comparator.comparingInt(Pokemon::getWeight).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getTallestPokemon() {
        return getAllPokemon().stream()
                .sorted(Comparator.comparingInt(Pokemon::getHeight).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getExperiencedPokemon() {
        return getAllPokemon().stream()
                .sorted(Comparator.comparingInt(Pokemon::getBaseExperience).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getAllPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon?offset=0&limit100";
        List<Pokemon> allPokemon = new ArrayList<>();
        Response response;

        while(true) {
            response = restTemplate.getForObject(url, Response.class);
            assert response != null;

            // Get pokémon objects in parallel
            List<CompletableFuture<Pokemon>> futures = response.getResults().stream()
                    .map(result -> CompletableFuture.supplyAsync(() -> restTemplate.getForObject(result.getUrl(), Pokemon.class)))
                    .toList();

            // Wait for all futures to complete
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            // Add pokémon objects to the list
            allPokemon.addAll(futures.stream().map(CompletableFuture::join).toList());

            if (response.getNext() == null) {
                return allPokemon;
            }

            // Next pokémon page
            url = response.getNext();
        }
    }
}
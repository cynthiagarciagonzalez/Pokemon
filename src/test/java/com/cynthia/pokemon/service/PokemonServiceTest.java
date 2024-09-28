package com.cynthia.pokemon.service;

import com.cynthia.pokemon.model.Pokemon;
import com.cynthia.pokemon.model.Response;
import com.cynthia.pokemon.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PokemonService pokemonService;

    @BeforeEach
    void setup() {
        Response response = new Response();
        response.setResults(List.of(new Result("https://pokeapi.co/api/v2/pokemon/1"), new Result("https://pokeapi.co/api/v2/pokemon/2")));

        Pokemon pokemon1 = new Pokemon("Pikachu", 10, 20, 30);
        Pokemon pokemon2 = new Pokemon("Charizard", 20, 30, 40);

        when(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon", Response.class)).thenReturn(response);
        when(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/1", Pokemon.class)).thenReturn(pokemon1);
        when(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/2", Pokemon.class)).thenReturn(pokemon2);
    }

    @Test
    void testGetAllPokemon() {
        List<Pokemon> listPokemon = pokemonService.getAllPokemon();

        assertNotNull(listPokemon);
        assertEquals(2, listPokemon.size());
    }

    @Test
    void testGetHeaviestPokemon() {
        List<Pokemon> heaviestPokemon = pokemonService.getHeaviestPokemon();

        assertNotNull(heaviestPokemon);
        assertEquals(2, heaviestPokemon.size());
    }

    @Test
    void testGetTallestPokemon() {
        List<Pokemon> tallestPokemon = pokemonService.getTallestPokemon();

        assertNotNull(tallestPokemon);
        assertEquals(2, tallestPokemon.size());
    }

    @Test
    void testGetExperiencedPokemon() {
        List<Pokemon> experiencedPokemon = pokemonService.getExperiencedPokemon();

        assertNotNull(experiencedPokemon);
        assertEquals(2, experiencedPokemon.size());
    }
}
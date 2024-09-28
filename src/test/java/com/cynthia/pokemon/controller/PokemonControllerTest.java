package com.cynthia.pokemon.controller;

import com.cynthia.pokemon.model.Pokemon;
import com.cynthia.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PokemonControllerTest {

    @Mock
    private PokemonService pokemonService;

    @InjectMocks
    private PokemonController pokemonController;

    @Test
    void testGetHeaviestPokemon() {
        List<Pokemon> heaviestPokemon = List.of(new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon());
        when(pokemonService.getHeaviestPokemon()).thenReturn(heaviestPokemon);

        ResponseEntity<List<Pokemon>> response = new ResponseEntity<>(pokemonController.getHeaviestPokemon(), HttpStatus.OK);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(heaviestPokemon, response.getBody());
    }

    @Test
    void testGetTallestPokemon() {
        List<Pokemon> tallestPokemon = List.of(new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon());
        when(pokemonService.getTallestPokemon()).thenReturn(tallestPokemon);

        ResponseEntity<List<Pokemon>> response = new ResponseEntity<>(pokemonController.getTallestPokemon(), HttpStatus.OK);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tallestPokemon, response.getBody());
    }

    @Test
    void testGetExperiencedPokemon() {
        List<Pokemon> experiencedPokemon = List.of(new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon());
        when(pokemonService.getExperiencedPokemon()).thenReturn(experiencedPokemon);

        ResponseEntity<List<Pokemon>> response = new ResponseEntity<>(pokemonController.getExperiencedPokemon(), HttpStatus.OK);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(experiencedPokemon, response.getBody());
    }
}
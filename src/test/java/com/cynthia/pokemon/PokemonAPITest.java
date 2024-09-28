package com.cynthia.pokemon;

import com.cynthia.pokemon.model.Pokemon;
import com.cynthia.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonAPITest {

    @Autowired
    private PokemonService pokemonService;

    @Test
    void testGetAllPokemon(){
        List<Pokemon> response = pokemonService.getAllPokemon();

        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    void testGetHeaviestPokemon(){
        List<Pokemon> heaviestPokemon = pokemonService.getHeaviestPokemon();

        assertNotNull(heaviestPokemon);
        assertEquals(5, heaviestPokemon.size());
    }

    @Test
    void testGetTallestPokemon(){
        List<Pokemon> tallestPokemon = pokemonService.getTallestPokemon();

        assertNotNull(tallestPokemon);
        assertEquals(5, tallestPokemon.size());
    }

    @Test
    void testGetExperiencedPokemon(){
        List<Pokemon> experiencedPokemon = pokemonService.getExperiencedPokemon();

        assertNotNull(experiencedPokemon);
        assertEquals(5, experiencedPokemon.size());
    }
}

package com.cynthia.pokemon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetHeaviestPokemon() throws Exception {
        mockMvc.perform(get("/api/pokemon/heaviest"))
                .andExpect(status().isOk());

        List heaviestPokemon = objectMapper.readValue(mockMvc.perform(get("/api/pokemon/heaviest")).andReturn().getResponse().getContentAsString(), List.class);
        assertNotNull(heaviestPokemon);
        assertEquals(5, heaviestPokemon.size());
    }

    @Test
    void testGetTallestPokemon() throws Exception {
        mockMvc.perform(get("/api/pokemon/tallest"))
                .andExpect(status().isOk());

        List tallestPokemon = objectMapper.readValue(mockMvc.perform(get("/api/pokemon/tallest")).andReturn().getResponse().getContentAsString(), List.class);
        assertNotNull(tallestPokemon);
        assertEquals(5, tallestPokemon.size());
    }

    @Test
    void testGetExperiencedPokemon() throws Exception {
        mockMvc.perform(get("/api/pokemon/experienced"))
                .andExpect(status().isOk());

        List mostExperiencedPokemon = objectMapper.readValue(mockMvc.perform(get("/api/pokemon/experienced")).andReturn().getResponse().getContentAsString(), List.class);
        assertNotNull(mostExperiencedPokemon);
        assertEquals(5, mostExperiencedPokemon.size());
    }
}

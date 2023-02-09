package com.example.springrecipe.controllers;

import com.example.springrecipe.repositories.RecipeRepository;
import com.example.springrecipe.service.RecipeService;
import jakarta.inject.Inject;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MockMvcTest {
    @Mock
    RecipeService recipeService;

    private static MockMvc mvc;

    @Test
    public void testIndexMapping() throws Exception {
        IndexController indexController = new IndexController(recipeService);
        mvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}

package com.prueba.tecnicabackend.controller;

import com.prueba.tecnicabackend.models.User;
import com.prueba.tecnicabackend.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldReturnUserWhenExists() throws Exception {
        User mockUser = new User("José", "Luis", "Pérez", "González", "123456789",
                "Calle Falsa 123", "Bogotá", 1003519864, "C");
        Mockito.when(userService.getUser("C", 1003519864))
                .thenReturn(Optional.of(mockUser));

        mockMvc.perform(get("/api/users")
                        .param("type", "C")
                        .param("numberDoc", "1003519864"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("José"));
    }

    @Test
    void shouldReturnNotFoundWhenUserDoesNotExist() throws Exception {
        Mockito.when(userService.getUser("C", 12345678))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users")
                        .param("type", "C")
                        .param("numberDoc", "12345678"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found."));
    }

    @Test
    void shouldReturnBadRequestForInvalidType() throws Exception {
        mockMvc.perform(get("/api/users")
                        .param("type", "X")
                        .param("numberDoc", "1003519864"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid document type."));
    }
}

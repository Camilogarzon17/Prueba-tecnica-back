package com.prueba.tecnicabackend.services;

import com.prueba.tecnicabackend.models.User;
import com.prueba.tecnicabackend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void shouldReturnUserWhenExists() {
        User mockUser = new User("José", "Luis", "Pérez", "González", "123456789",
                "Calle Falsa 123", "Bogotá", 1003519864, "C");
        Mockito.when(userRepository.findByTypeAndNumberDoc("C", 1003519864))
                .thenReturn(Optional.of(mockUser));

        Optional<User> result = userService.getUser("C", 1003519864);
        assertTrue(result.isPresent());
    }

    @Test
    void shouldReturnEmptyWhenUserDoesNotExist() {
        Mockito.when(userRepository.findByTypeAndNumberDoc("C", 12345678))
                .thenReturn(Optional.empty());

        Optional<User> result = userService.getUser("C", 12345678);
        assertFalse(result.isPresent());
    }
}

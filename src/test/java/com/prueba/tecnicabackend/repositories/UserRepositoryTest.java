package com.prueba.tecnicabackend.repositories;

import com.prueba.tecnicabackend.models.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserRepositoryTest {

    @Test
    void shouldReturnUserWhenExists() {
        UserRepository repository = new UserRepository();
        Optional<User> user = repository.findByTypeAndNumberDoc("C", 1003519864);

        assertTrue(user.isPresent());
    }

    @Test
    void shouldReturnEmptyWhenUserDoesNotExist() {
        UserRepository repository = new UserRepository();
        Optional<User> user = repository.findByTypeAndNumberDoc("P", 12345678);

        assertFalse(user.isPresent());
    }
}

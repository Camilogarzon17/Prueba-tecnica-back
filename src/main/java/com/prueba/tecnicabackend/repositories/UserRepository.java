package com.prueba.tecnicabackend.repositories;

import com.prueba.tecnicabackend.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();

        users.add(new User("José", "Luis", "Pérez", "González", "123456789", "Calle Falsa 123",
                "Bogotá", 1003519864, "C"));
    }

    public Optional<User> findByTypeAndNumberDoc(String type, int numberDoc) {
        return users.stream()
                .filter(user -> user.getDocType().equals(type) && user.getNumberDoc() == numberDoc)
                .findFirst();

    }
}

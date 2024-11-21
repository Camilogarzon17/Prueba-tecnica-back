package com.prueba.tecnicabackend.services;


import com.prueba.tecnicabackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.prueba.tecnicabackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(String type, int numberDoc) {
        return userRepository.findByTypeAndNumberDoc(type, numberDoc);
    }

}

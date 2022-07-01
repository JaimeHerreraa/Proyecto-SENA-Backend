package com.sena.backend.service;

import com.sena.backend.model.User;
import com.sena.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser() {
        return userRepository.findById(1);
    }
}

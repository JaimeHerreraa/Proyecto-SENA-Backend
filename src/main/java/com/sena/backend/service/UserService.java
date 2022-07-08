package com.sena.backend.service;

import com.sena.backend.model.User;
import com.sena.backend.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository IUserRepository;

    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public Optional<User> getUser() {
        return IUserRepository.findById(1);
    }

}

package com.airbnb.service;

import com.airbnb.model.User;
import com.airbnb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for User entity.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find a user by its ID.
     *
     * @param id User ID
     * @return Optional of User
     */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}

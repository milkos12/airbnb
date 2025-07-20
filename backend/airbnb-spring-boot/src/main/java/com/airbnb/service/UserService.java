package com.airbnb.service;

import com.airbnb.dto.user.CreateUserRequestDTO;
import com.airbnb.dto.user.UserResponseDTO;
import com.airbnb.dto.user.UserUpdateDTO;
import com.airbnb.exception.user.UserNotFountException;
import com.airbnb.mapper.UserMapper;
import com.airbnb.model.User;
import com.airbnb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for User entity.
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponseDTO)
                .toList();
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

    public UserResponseDTO getUserById(Long id) {
        return userMapper.userToUserResponseDTO(userRepository.findById(id)
                .orElseThrow(()-> new UserNotFountException("Usuario no encontrado con el ID: ", id))
        );
    }

    public UserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) {
        User user = userMapper.CreateUserRequestDTOToUser(createUserRequestDTO);
        User savedUser = userRepository.save(user);
        return  userMapper.userToUserResponseDTO(savedUser);
    }

    @Transactional
    public UserResponseDTO UserResponseDTO (Long id, UserUpdateDTO userUpdateDTO){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFountException("Usuaio no encontrado con ID: "+ id, id));

        User updatedUser = userMapper.updateUserFromDTO(existingUser, userUpdateDTO);
        return userMapper.userToUserResponseDTO(userRepository.save(updatedUser));
    }
 }

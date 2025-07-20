package com.airbnb.mapper;

import com.airbnb.dto.user.CreateUserRequestDTO;
import com.airbnb.dto.user.UserResponseDTO;
import com.airbnb.dto.user.UserUpdateDTO;
import com.airbnb.model.User;

public class UserMapper {
    public UserResponseDTO userToUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCountry(),
                user.getCity(),
                user.getBornDate(),
                user.getProfilePhoto()
        );
    }

    public User CreateUserRequestDTOToUser(CreateUserRequestDTO createUserRequestDTO) {
        return new User(
                createUserRequestDTO.firstName(),
                createUserRequestDTO.lastName(),
                createUserRequestDTO.email(),
                createUserRequestDTO.phoneNumber(),
                createUserRequestDTO.country(),
                createUserRequestDTO.city(),
                createUserRequestDTO.bornDate(),
                createUserRequestDTO.ulrPhoto(),
                createUserRequestDTO.passwordHash()
        );
    }

    public UserResponseDTO UserToUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCountry(),
                user.getCity(),
                user.getBornDate(),
                user.getCity()
        );
    }

    public User updateUserFromDTO(User user, UserUpdateDTO userUpdate) {
        user.setFirstName(userUpdate.firstName());
        user.setLastName(userUpdate.lastName());
        user.setBornDate(userUpdate.bornDate());
        user.setCity(userUpdate.city());
        user.setCountry(userUpdate.country());
        user.setEmail(userUpdate.email());
        user.setPhoneNumber(userUpdate.phoneNumber());
        return user;
    }
}

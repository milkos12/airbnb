package com.airbnb.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Calendar;

public record CreateUserRequestDTO(

        @NotBlank(message = "First name is mandatory")
        @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String lastName,

        @NotBlank(message = "Email is mandatory")
        @Size(min = 1, max = 100, message = "Email must be between 1 and 100 characters")
        String email,

        @NotBlank(message = "Phone number is mandatory")
        @Size(min = 1, max = 100, message = "Email must be between 1 and 100 characters")
        String phoneNumber,

        @NotBlank(message = "Country number is mandatory")
        @Size(min = 1, max = 100, message = "Country must be between 1 and 100 characters")
        String country,

        @NotBlank(message = "City number is mandatory")
        @Size(min = 1, max = 100, message = "City must be between 1 and 100 characters")
        String city,

        @NotBlank(message = "Born date is mandatory")
        Calendar bornDate,

        String ulrPhoto,

        @NotBlank(message = "Password date is mandatory")
        String passwordHash
){

}

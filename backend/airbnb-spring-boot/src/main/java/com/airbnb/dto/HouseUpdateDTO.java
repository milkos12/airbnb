package com.airbnb.dto;

import com.airbnb.model.IncludedService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public record HouseUpdateDTO(

        @NotBlank(message = "Name is mandatory")
        @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String name,

        @PositiveOrZero(message = "Guests must be positive or zero")
        int guests,

        @PositiveOrZero(message = "Rooms must be positive or zero")
        int rooms,

        @PositiveOrZero(message = "Beds must be positive or zero")
        int beds,

        @PositiveOrZero(message = "Bathrooms must be positive or zero")
        int bathrooms,

        @NotBlank(message = "City is mandatory")
        @Size(min = 1, max = 100, message = "City must be between 1 and 100 characters")
        String city,

        @NotBlank(message = "Country is mandatory")
        @Size(min = 1, max = 100, message = "Country must be between 1 and 100 characters")
        String country,

        @NotBlank(message = "Coordinates is mandatory")
        @Size(min = 1, max = 100, message = "Coordinates must be between 1 and 100 characters")
        String coordinates,

        List<String> photos,

        @NotBlank(message = "Full address is mandatory")
        @Size(min = 1, max = 100, message = "Full address must be between 1 and 100 characters")
        String fullAddress,

        @PositiveOrZero(message = "Night price must be positive or zero")
        Float nightPrice,

        List<IncludedService> includedServices
) {
}

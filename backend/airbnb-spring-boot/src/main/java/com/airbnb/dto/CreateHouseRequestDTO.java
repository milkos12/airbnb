package com.airbnb.dto;

import jakarta.validation.constraints.*;

/***
 * CreateHouseRequestDTO is a data transfer object used to transfer data between the client and the server.
 * @param name the name of the house
 * @param userId the ID of the user
 * @param guests the number of guests
 * @param rooms the number of rooms
 * @param beds the number of beds
 * @param bathrooms the number of bathrooms
 * @param city the city where the house is located
 * @param country the country where the house is located
 * @param coordinates the string representation of the coordinates
 * @param fullAddress the string representation of the full address
 * @param nightPrice the float representation of the night price
 */
public record CreateHouseRequestDTO(
        @NotBlank(message = "Name is mandatory")
        @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String name,

        @NotNull(message = "User ID is mandatory")
        @PositiveOrZero(message = "User ID must be positive or zero")
        Long userId,

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

        @NotBlank(message = "Full address is mandatory")
        @Size(min = 1, max = 100, message = "Full address must be between 1 and 100 characters")
        String fullAddress,

        @PositiveOrZero(message = "Night price must be positive or zero")
        Float nightPrice
) {
}

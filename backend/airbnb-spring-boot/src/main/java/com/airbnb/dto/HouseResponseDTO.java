package com.airbnb.dto;

public record HouseResponseDTO(
        Long id,
        String name,
        Long userId,
        int guests,
        int rooms,
        int beds,
        int bathrooms,
        String city,
        String country,
        String coordinates,
        String fullAddress,
        Float nightPrice
) {
}

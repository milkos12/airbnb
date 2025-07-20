package com.airbnb.dto.user;

import java.util.Calendar;

public record UserResponseDTO(
    Long id,
    String firstName,
    String LastName,
    String email,
    String phoneNumber,
    String country,
    String city,
    Calendar bornDay,
    String ulrPhoto
) {
}

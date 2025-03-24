package com.airbnb.mapper;

import com.airbnb.dto.CreateHouseRequestDTO;
import com.airbnb.dto.HouseResponseDTO;
import com.airbnb.model.House;
import com.airbnb.model.User;
import org.springframework.stereotype.Service;

/**
 * Mapper class for House entity, used to map House entity to DTOs and vice versa.
 */
@Service
public class HouseMapper {
    public HouseResponseDTO houseToHouseResponseDTO(House house) {
        return new HouseResponseDTO(
                house.getHouseId(),
                house.getName(),
                house.getUser().getUserId(),
                house.getGuests(),
                house.getRooms(),
                house.getBeds(),
                house.getBathrooms(),
                house.getCity(),
                house.getCountry(),
                house.getCoordinates(),
                house.getFullAddress(),
                house.getNightPrice()
        );
    }

    public House CreateHouseRequestDTOToHouse(CreateHouseRequestDTO createHouseRequestDTO, User user) {
        return new House(
                createHouseRequestDTO.name(),
                user,
                createHouseRequestDTO.guests(),
                createHouseRequestDTO.rooms(),
                createHouseRequestDTO.beds(),
                createHouseRequestDTO.bathrooms(),
                createHouseRequestDTO.city(),
                createHouseRequestDTO.country(),
                createHouseRequestDTO.coordinates(),
                null, // null value for the moment
                createHouseRequestDTO.fullAddress(),
                createHouseRequestDTO.nightPrice(),
                null // null value for the moment
        );
    }

}

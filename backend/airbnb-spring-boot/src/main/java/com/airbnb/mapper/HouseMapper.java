package com.airbnb.mapper;

import com.airbnb.dto.HouseResponseDTO;
import com.airbnb.model.House;

/**
 * Mapper class for House entity, used to map House entity to DTOs and vice versa.
 */
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
}

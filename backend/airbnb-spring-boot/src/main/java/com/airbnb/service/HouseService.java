package com.airbnb.service;

import com.airbnb.dto.CreateHouseRequestDTO;
import com.airbnb.dto.HouseResponseDTO;
import com.airbnb.exception.HouseNotFoundException;
import com.airbnb.exception.UserNotFoundException;
import com.airbnb.mapper.HouseMapper;
import com.airbnb.model.House;
import com.airbnb.model.User;
import com.airbnb.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;
    private final UserService userService;

    public HouseService(
            HouseRepository houseRepository, HouseMapper houseMapper, UserService userService
    ) {
        this.houseRepository = houseRepository;
        this.houseMapper = houseMapper;
        this.userService = userService;
    }

    /**
     * Get all houses.
     *
     * @return List of HouseResponseDTOs
     */
    public List<HouseResponseDTO> getAllHouses() {
        return houseRepository.findAll().stream()
                .map(houseMapper::houseToHouseResponseDTO)
                .toList();
    }

    /**
     * Get a house by its ID.
     *
     * @param id House ID
     * @return HouseResponseDTO
     * @throws HouseNotFoundException if the house is not found
     */
    public HouseResponseDTO getHouseById(Long id) {
        return houseMapper.houseToHouseResponseDTO(houseRepository.findById(id).orElseThrow(() -> new HouseNotFoundException("Casa no encontrada con ID: " + id)));
    }

    /**
     * Create a house.
     *
     * @param createHouseRequestDTO CreateHouseRequestDTO
     * @return HouseResponseDTO
     * @throws UserNotFoundException if the user is not found
     */
    public HouseResponseDTO createHouse(CreateHouseRequestDTO createHouseRequestDTO) {
        // Find the user by ID
        User user = userService.findById(createHouseRequestDTO.userId()).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + createHouseRequestDTO.userId()));
        // Map the request DTO to a House entity
        House house = houseMapper.CreateHouseRequestDTOToHouse(createHouseRequestDTO, user);
        // Save the house
        House savedHouse = houseRepository.save(house);
        return houseMapper.houseToHouseResponseDTO(savedHouse);
    }

    /**
     * Delete a house by its ID.
     * @param id House ID
     */
    public void deleteHouseById(Long id) {
        houseRepository.deleteById(id);
    }

}

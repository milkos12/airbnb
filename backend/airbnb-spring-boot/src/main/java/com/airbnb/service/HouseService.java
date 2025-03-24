package com.airbnb.service;

import com.airbnb.dto.HouseResponseDTO;
import com.airbnb.exception.HouseNotFoundException;
import com.airbnb.mapper.HouseMapper;
import com.airbnb.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;

    public HouseService(
            HouseRepository houseRepository, HouseMapper houseMapper
    ) {
        this.houseRepository = houseRepository;
        this.houseMapper = houseMapper;
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

}

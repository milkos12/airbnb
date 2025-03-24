package com.airbnb.service;

import com.airbnb.dto.HouseResponseDTO;
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

    public HouseResponseDTO getHouseById(Long id) {
        return houseMapper.houseToHouseResponseDTO(houseRepository.findById(id).orElseThrow(new HouseNotFoundException("Casa no encontrada con ID: " + id)));
    }

}

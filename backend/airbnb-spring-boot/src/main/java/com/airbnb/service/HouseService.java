package com.airbnb.service;

import com.airbnb.repository.HouseRepository;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }
}

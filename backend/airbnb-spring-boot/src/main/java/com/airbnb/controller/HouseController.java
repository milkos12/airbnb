package com.airbnb.controller;

import com.airbnb.model.House;
import com.airbnb.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public ResponseEntity<List<House>> getAllHouses() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<House> createHouse(House house) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        return null;
    }

}

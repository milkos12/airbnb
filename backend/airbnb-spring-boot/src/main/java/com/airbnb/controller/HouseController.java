package com.airbnb.controller;

import com.airbnb.dto.CreateHouseRequestDTO;
import com.airbnb.dto.HouseResponseDTO;
import com.airbnb.dto.HouseUpdateDTO;
import com.airbnb.service.HouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<HouseResponseDTO>> getAllHouses() {
        return ResponseEntity.ok(houseService.getAllHouses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseResponseDTO> getHouseById(@PathVariable Long id) {
        return ResponseEntity.ok(houseService.getHouseById(id));
    }

    @PostMapping
    public ResponseEntity<HouseResponseDTO> createHouse(@RequestBody @Valid CreateHouseRequestDTO createHouseRequestDTO) {
        return new ResponseEntity<>(houseService.createHouse(createHouseRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseResponseDTO> updateHouse(@PathVariable Long id, @RequestBody @Valid HouseUpdateDTO houseUpdateDTO) {
        return ResponseEntity.ok(houseService.updateHouse(id, houseUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.noContent().build();
    }

}

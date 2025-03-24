package com.airbnb.controller;

import com.airbnb.service.HouseService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }
}

package com.example.carshowroom.controller;

import com.example.carshowroom.dto.request.*;
import com.example.carshowroom.dto.response.CarResponse;
import com.example.carshowroom.service.CarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController
{
    private final CarService carService;

    @PostMapping
    public CarResponse createCar(
            @Valid @RequestBody CarCreateRequest request
    )
    {
        return carService.createCar(request);
    }

    @GetMapping
    public Page<CarResponse> getAllCars(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    )
    {
        return carService.getAllCars(keyword, page, size);
    }

    @PutMapping("/{id}")
    public CarResponse updateCar(
            @PathVariable Long id,
            @Valid @RequestBody CarUpdateRequest request
    )
    {
        return carService.updateCar(id, request);
    }

    @PatchMapping("/{id}")
    public CarResponse patchCar(
            @PathVariable Long id,
            @RequestBody CarUpdateRequest request
    )
    {
        return carService.patchCar(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id)
    {
        carService.deleteCar(id);

        return "Deleted successfully";
    }
}
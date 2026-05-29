package com.example.carshowroom.service;

import com.example.carshowroom.dto.request.*;
import com.example.carshowroom.dto.response.CarResponse;
import org.springframework.data.domain.Page;

public interface CarService
{
    CarResponse createCar(CarCreateRequest request);

    Page<CarResponse> getAllCars(
            String keyword,
            int page,
            int size
    );

    CarResponse updateCar(
            Long id,
            CarUpdateRequest request
    );

    CarResponse patchCar(
            Long id,
            CarUpdateRequest request
    );

    void deleteCar(Long id);
}
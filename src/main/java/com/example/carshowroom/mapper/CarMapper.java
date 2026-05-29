package com.example.carshowroom.mapper;

import com.example.carshowroom.dto.response.CarResponse;
import com.example.carshowroom.entity.Car;

public class CarMapper
{
    public static CarResponse toResponse(Car car)
    {
        return CarResponse.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .price(car.getPrice())
                .status(car.getStatus())
                .build();
    }
}
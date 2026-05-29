package com.example.carshowroom.dto.response;

import com.example.carshowroom.entity.CarStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponse
{
    private Long id;

    private String model;

    private String brand;

    private double price;

    private CarStatus status;
}
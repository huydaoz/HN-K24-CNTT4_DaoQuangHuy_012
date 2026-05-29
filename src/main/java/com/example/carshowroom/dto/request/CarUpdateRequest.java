package com.example.carshowroom.dto.request;

import com.example.carshowroom.entity.CarStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdateRequest
{
    @NotBlank(message = "Model must not be blank")
    private String model;

    @NotBlank(message = "Brand must not be blank")
    private String brand;

    @Positive(message = "Price must be greater than 0")
    private double price;

    private CarStatus status;
}
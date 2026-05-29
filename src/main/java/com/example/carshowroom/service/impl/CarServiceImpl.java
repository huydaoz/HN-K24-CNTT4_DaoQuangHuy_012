package com.example.carshowroom.service.impl;

import com.example.carshowroom.dto.request.*;
import com.example.carshowroom.dto.response.CarResponse;
import com.example.carshowroom.entity.Car;
import com.example.carshowroom.exception.ResourceNotFoundException;
import com.example.carshowroom.mapper.CarMapper;
import com.example.carshowroom.repository.CarRepository;
import com.example.carshowroom.service.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService
{
    private final CarRepository carRepository;

    @Override
    public CarResponse createCar(CarCreateRequest request)
    {
        Car car = Car.builder()
                .model(request.getModel())
                .brand(request.getBrand())
                .price(request.getPrice())
                .status(request.getStatus())
                .isDeleted(false)
                .build();

        return CarMapper.toResponse(
                carRepository.save(car)
        );
    }

    @Override
    public Page<CarResponse> getAllCars(
            String keyword,
            int page,
            int size
    )
    {
        Pageable pageable = PageRequest.of(page, size);

        Page<Car> cars =
                carRepository
                        .findByModelContainingIgnoreCaseOrBrandContainingIgnoreCase(
                                keyword,
                                keyword,
                                pageable
                        );

        return cars.map(CarMapper::toResponse);
    }

    @Override
    public CarResponse updateCar(
            Long id,
            CarUpdateRequest request
    )
    {
        Car car = carRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Car not found")
                );

        car.setModel(request.getModel());
        car.setBrand(request.getBrand());
        car.setPrice(request.getPrice());
        car.setStatus(request.getStatus());

        return CarMapper.toResponse(
                carRepository.save(car)
        );
    }

    @Override
    public CarResponse patchCar(
            Long id,
            CarUpdateRequest request
    )
    {
        Car car = carRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Car not found")
                );

        if (request.getModel() != null)
        {
            car.setModel(request.getModel());
        }

        if (request.getBrand() != null)
        {
            car.setBrand(request.getBrand());
        }

        if (request.getPrice() > 0)
        {
            car.setPrice(request.getPrice());
        }

        if (request.getStatus() != null)
        {
            car.setStatus(request.getStatus());
        }

        return CarMapper.toResponse(
                carRepository.save(car)
        );
    }

    @Override
    public void deleteCar(Long id)
    {
        Car car = carRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Car not found")
                );

        car.setDeleted(true);

        carRepository.save(car);
    }
}
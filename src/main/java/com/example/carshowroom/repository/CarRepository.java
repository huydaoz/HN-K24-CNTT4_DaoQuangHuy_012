package com.example.carshowroom.repository;

import com.example.carshowroom.entity.Car;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>
{
    Page<Car> findByModelContainingIgnoreCaseOrBrandContainingIgnoreCase(
            String model,
            String brand,
            Pageable pageable
    );
}
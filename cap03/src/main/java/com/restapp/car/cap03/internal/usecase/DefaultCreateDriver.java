package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.CreateDriver;
import com.restapp.car.cap03.internal.entity.Driver;
import com.restapp.car.cap03.internal.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCreateDriver implements CreateDriver {

    private final DriverRepository driverRepository;

    @Override
    public Driver execute(Driver driver) {
        return this.driverRepository.save(driver);
    }
}

package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.RetrieveAllDrivers;
import com.restapp.car.cap03.internal.entity.Driver;
import com.restapp.car.cap03.internal.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveAllDrivers implements RetrieveAllDrivers {

    private final DriverRepository driverRepository;

    @Override
    public Page<Driver> execute(Pageable pageable) {
        return this.driverRepository.findAll(pageable);
    }
}

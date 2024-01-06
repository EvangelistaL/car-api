package com.restapp.car.cap03.internal.controller;


import com.restapp.car.cap03.api.controller.DriverController;
import com.restapp.car.cap03.api.usecase.*;
import com.restapp.car.cap03.internal.entity.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(DriverController.class)
public class DefaultDriverController implements DriverController{

    private final CreateDriver createDriver;

    private final DeleteDriverById deleteDriverById;

    private final IncrementalUpdateDriver incrementalUpdateDriver;

    private final RetrieveAllDrivers retrieveAllDrivers;

    private final RetrieveDriverById retrieveDriverById;

    private final UpdateDriver updateDriver;

    @Override
    public Page<Driver> retrieveAllDrivers(Pageable pageable) {
        return this.retrieveAllDrivers.execute(pageable);
    }

    @Override
    public Driver retrieveDriverById(Long id) {
        return this.retrieveDriverById.execute(id);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return this.createDriver.execute(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver driver) {
        return this.updateDriver.execute(id, driver);
    }

    @Override
    public Driver incrementalUpdateDriver(Long id, Driver driver) {
        return this.incrementalUpdateDriver.execute(id, driver);
    }

    @Override
    public void deleteDriverById(Long id) {
        this.deleteDriverById.execute(id);
    }
}

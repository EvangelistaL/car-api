package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.RetrieveDriverById;
import com.restapp.car.cap03.api.usecase.UpdateDriver;
import com.restapp.car.cap03.internal.entity.Driver;
import com.restapp.car.cap03.internal.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUpdateDriver implements UpdateDriver {

    private final RetrieveDriverById driverById;

    private final DriverRepository driverRepository;

    @Override
    public Driver execute(Long id, Driver driver) {
        return this.driverRepository.save(this.retrieveDriver(id, driver));
    }

    private Driver retrieveDriver(Long id, Driver driver){
        Driver driverFound = this.driverById.execute(id);
        driverFound.setName(driver.getName());
        driverFound.setBirthDate(driver.getBirthDate());
        return driverFound;
    }
}

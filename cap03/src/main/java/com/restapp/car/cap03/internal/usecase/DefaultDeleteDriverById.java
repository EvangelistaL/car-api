package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.DeleteDriverById;
import com.restapp.car.cap03.api.usecase.RetrieveDriverById;
import com.restapp.car.cap03.internal.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeleteDriverById implements DeleteDriverById {

    private final RetrieveDriverById retrieveDriverById;

    private final DriverRepository driverRepository;

    @Override
    public void execute(Long id) {
        this.driverRepository.delete(this.retrieveDriverById.execute(id));
    }
}

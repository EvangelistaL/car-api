package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.RetrieveDriverById;
import com.restapp.car.cap03.internal.entity.Driver;
import com.restapp.car.cap03.internal.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveDriverById implements RetrieveDriverById {

    private final DriverRepository driverRepository;

    @Override
    public Driver execute(Long id) {
        return this.driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Driver with id %d not found", id)));
    }
}

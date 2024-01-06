package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.RetrieveAllPassengers;
import com.restapp.car.cap03.internal.entity.Passenger;
import com.restapp.car.cap03.internal.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveAllPassengers implements RetrieveAllPassengers {

    private final PassengerRepository passengerRepository;

    @Override
    public Page<Passenger> execute(Pageable pageable) {
        return this.passengerRepository.findAll(pageable);
    }
}

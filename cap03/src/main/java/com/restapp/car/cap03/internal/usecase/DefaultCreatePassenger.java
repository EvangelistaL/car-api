package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.CreatePassenger;
import com.restapp.car.cap03.internal.entity.Passenger;
import com.restapp.car.cap03.internal.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCreatePassenger implements CreatePassenger {

    private final PassengerRepository passengerRepository;

    @Override
    public Passenger execute(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }
}

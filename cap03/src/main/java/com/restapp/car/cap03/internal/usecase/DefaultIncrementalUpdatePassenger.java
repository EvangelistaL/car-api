package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.IncrementalUpdatePassenger;
import com.restapp.car.cap03.api.usecase.RetrievePassengerById;
import com.restapp.car.cap03.internal.entity.Passenger;
import com.restapp.car.cap03.internal.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultIncrementalUpdatePassenger implements IncrementalUpdatePassenger {

    private final RetrievePassengerById retrievePassengerById;

    private final PassengerRepository passengerRepository;

    @Override
    public Passenger execute(Long id, Passenger passenger) {
        return this.passengerRepository.save(retrievePassenger(id, passenger));
    }

    private Passenger retrievePassenger(Long id, Passenger passenger){
        Passenger passengerFound = this.retrievePassengerById.execute(id);
        passengerFound.setName(Optional.ofNullable(passenger.getName())
                .orElse(passengerFound.getName()));
        return passengerFound;
    }
}

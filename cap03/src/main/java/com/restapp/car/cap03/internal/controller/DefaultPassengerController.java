package com.restapp.car.cap03.internal.controller;

import com.restapp.car.cap03.api.controller.PassengerController;
import com.restapp.car.cap03.api.usecase.*;
import com.restapp.car.cap03.internal.entity.Passenger;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(PassengerController.class)
public class DefaultPassengerController implements PassengerController {

    private final CreatePassenger createPassenger;

    private final DeletePassengerById deletePassengerById;

    private final IncrementalUpdatePassenger incrementalUpdatePassenger;

    private final RetrieveAllPassengers retrieveAllPassengers;

    private final RetrievePassengerById retrievePassengerById;

    private final UpdatePassenger updatePassenger;

    @Override
    public Page<Passenger> retrieveAllPassengers(Pageable pageable) {
        return this.retrieveAllPassengers.execute(pageable);
    }

    @Override
    public Passenger retrievePassengerById(Long id) {
        return this.retrievePassengerById.execute(id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return this.createPassenger.execute(passenger);
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger passenger) {
        return this.updatePassenger.execute(id, passenger);
    }

    @Override
    public Passenger incrementalUpdatePassenger(Long id, Passenger passenger) {
        return this.incrementalUpdatePassenger.execute(id, passenger);
    }

    @Override
    public void deletePassengerById(Long id) {
        this.deletePassengerById.execute(id);
    }
}

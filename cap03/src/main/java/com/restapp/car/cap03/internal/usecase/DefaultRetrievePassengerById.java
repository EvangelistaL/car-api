package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.RetrievePassengerById;
import com.restapp.car.cap03.internal.entity.Passenger;
import com.restapp.car.cap03.internal.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrievePassengerById implements RetrievePassengerById {

    private final PassengerRepository passengerRepository;

    @Override
    public Passenger execute(Long id) {
        return this.passengerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Passenger with id = %d not found", id)));
    }

}

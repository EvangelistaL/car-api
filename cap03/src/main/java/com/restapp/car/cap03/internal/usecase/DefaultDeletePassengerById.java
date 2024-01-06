package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.usecase.DeletePassengerById;
import com.restapp.car.cap03.api.usecase.RetrievePassengerById;
import com.restapp.car.cap03.internal.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeletePassengerById implements DeletePassengerById {

    private final RetrievePassengerById retrievePassengerById;

    private final PassengerRepository passengerRepository;

    @Override
    public void execute(Long id) {
        this.passengerRepository.delete(this.retrievePassengerById.execute(id));
    }
}

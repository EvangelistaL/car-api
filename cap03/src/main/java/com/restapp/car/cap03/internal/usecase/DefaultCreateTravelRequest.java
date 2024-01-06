package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.model.TravelRequestInput;
import com.restapp.car.cap03.api.usecase.CreateTravelRequest;
import com.restapp.car.cap03.api.usecase.RetrievePassengerById;
import com.restapp.car.cap03.internal.entity.TravelRequest;
import com.restapp.car.cap03.internal.entity.enums.TravelRequestStatus;
import com.restapp.car.cap03.internal.repository.TravelRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DefaultCreateTravelRequest implements CreateTravelRequest {

    private final TravelRequestRepository travelRequestRepository;

    private final RetrievePassengerById retrievePassengerById;

    @Override
    public TravelRequest execute(TravelRequestInput travelRequestInput) {
        return this.travelRequestRepository.save(settingTravelRequest(travelRequestInput));
    }

    private TravelRequest settingTravelRequest(TravelRequestInput travelRequestInput){
        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setTravelRequestStatus(TravelRequestStatus.CREATED);
        travelRequest.setTravelRequestDate(LocalDateTime.now());
        travelRequest.setOrigin(travelRequestInput.origin());
        travelRequest.setDestination(travelRequestInput.destination());
        travelRequest.setPassenger(this.retrievePassengerById.execute(travelRequestInput.passengerId()));
        return travelRequest;
    }
}

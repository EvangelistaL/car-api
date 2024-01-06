package com.restapp.car.cap03.internal.controller;

import com.restapp.car.cap03.api.controller.TravelRequestController;
import com.restapp.car.cap03.api.model.TravelRequestInput;
import com.restapp.car.cap03.api.model.TravelRequestOutput;
import com.restapp.car.cap03.api.usecase.CreateTravelRequest;
import com.restapp.car.cap03.internal.entity.TravelRequest;
import com.restapp.car.cap03.internal.utils.TravelRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(TravelRequestController.class)
public class DefaultTravelRequestController implements TravelRequestController {

    private final CreateTravelRequest createTravelRequest;

    @Override
    public EntityModel<TravelRequestOutput> createTravelRequest(TravelRequestInput travelRequestInput) {
        TravelRequest travelRequest = this.createTravelRequest.execute(travelRequestInput);
        TravelRequestOutput output = TravelRequestMapper.map(travelRequest);
        return TravelRequestMapper.buildOutputModel(travelRequest, output);
    }
}

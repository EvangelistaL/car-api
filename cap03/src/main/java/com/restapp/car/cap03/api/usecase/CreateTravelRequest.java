package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.api.model.TravelRequestInput;
import com.restapp.car.cap03.internal.entity.TravelRequest;

public interface CreateTravelRequest {

    TravelRequest execute(TravelRequestInput travelRequestInput);
}

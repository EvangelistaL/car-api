package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.api.model.TravelRequestOutput;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface RetrieveNearbyRequests {

    List<EntityModel<TravelRequestOutput>> execute(String currentAddress);
}

package com.restapp.car.cap03.api.controller;

import com.restapp.car.cap03.api.model.TravelRequestInput;
import com.restapp.car.cap03.api.model.TravelRequestOutput;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "travelRequests")
public interface TravelRequestController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EntityModel<TravelRequestOutput> createTravelRequest(@RequestBody TravelRequestInput travelRequestInput);


    @GetMapping(path = "/nearby")
    @ResponseStatus(HttpStatus.OK)
    List<EntityModel<TravelRequestOutput>> retrieveNearbyRequests(@RequestParam String currentAddress);
}

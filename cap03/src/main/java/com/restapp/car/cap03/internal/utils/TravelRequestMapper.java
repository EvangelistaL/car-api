package com.restapp.car.cap03.internal.utils;

import com.restapp.car.cap03.api.controller.PassengerController;
import com.restapp.car.cap03.api.model.TravelRequestOutput;
import com.restapp.car.cap03.internal.entity.TravelRequest;
import lombok.experimental.UtilityClass;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@UtilityClass
public class TravelRequestMapper {

    public static TravelRequestOutput map(TravelRequest travelRequest){
        return new TravelRequestOutput(travelRequest.getId(), travelRequest.getOrigin(), travelRequest.getDestination(),
                travelRequest.getTravelRequestDate(), travelRequest.getTravelRequestStatus());
    }

    public EntityModel<TravelRequestOutput> buildOutputModel(TravelRequest travelRequest,
                                                             TravelRequestOutput travelRequestOutput){
        EntityModel<TravelRequestOutput> entityModel = EntityModel.of(travelRequestOutput);

        Link passengerLink = WebMvcLinkBuilder.linkTo(PassengerController.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        entityModel.add(passengerLink);
        return entityModel;
    }
}

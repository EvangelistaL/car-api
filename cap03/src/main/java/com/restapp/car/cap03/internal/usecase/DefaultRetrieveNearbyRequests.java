package com.restapp.car.cap03.internal.usecase;

import com.restapp.car.cap03.api.model.TravelRequestOutput;
import com.restapp.car.cap03.api.specification.TravelRequestSpecification;
import com.restapp.car.cap03.api.usecase.GoogleMapsService;
import com.restapp.car.cap03.api.usecase.RetrieveNearbyRequests;
import com.restapp.car.cap03.internal.entity.TravelRequest;
import com.restapp.car.cap03.internal.entity.enums.TravelRequestStatus;
import com.restapp.car.cap03.internal.repository.TravelRequestRepository;
import com.restapp.car.cap03.internal.utils.TravelRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveNearbyRequests implements RetrieveNearbyRequests {

    private static final int MAX_TRAVEL_TIME = 600;

    private final GoogleMapsService googleMapsService;

    private final TravelRequestRepository travelRequestRepository;

    @Override
    public List<EntityModel<TravelRequestOutput>> execute(String currentAddress) {
        return this.findTravelRequestWithStatusCreated().stream()
                .filter(travelRequest -> googleMapsService
                        .consultDistanceBetweenAddresses(currentAddress, travelRequest.getOrigin()) < MAX_TRAVEL_TIME)
                .map(travelRequest -> TravelRequestMapper.buildOutputModel(travelRequest, TravelRequestMapper.map(travelRequest)))
                .toList();
    }

    private List<TravelRequest> findTravelRequestWithStatusCreated(){
        List<TravelRequest> travelRequests = this.travelRequestRepository
                .findAll(TravelRequestSpecification.findByStatus(TravelRequestStatus.CREATED), Pageable.unpaged())
                .stream()
                .toList();
        if (travelRequests.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return travelRequests;
    }
}

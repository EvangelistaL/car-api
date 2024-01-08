package com.restapp.car.cap03.api.specification;

import com.querydsl.core.types.Predicate;
import com.restapp.car.cap03.internal.entity.QTravelRequest;
import com.restapp.car.cap03.internal.entity.enums.TravelRequestStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TravelRequestSpecification {

    private static final QTravelRequest qTravelRequest = QTravelRequest.travelRequest;

    public static Predicate findByStatus(TravelRequestStatus travelRequestStatus){
        return qTravelRequest.travelRequestStatus.eq(travelRequestStatus);
    }
}

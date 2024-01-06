package com.restapp.car.cap03.api.model;

import com.restapp.car.cap03.internal.entity.enums.TravelRequestStatus;

import java.time.LocalDateTime;

public record TravelRequestOutput(Long id, String origin, String destination, LocalDateTime travelRequestDate, TravelRequestStatus travelRequestStatus) {
}

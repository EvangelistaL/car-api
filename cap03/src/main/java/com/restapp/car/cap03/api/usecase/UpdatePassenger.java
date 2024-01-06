package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.internal.entity.Passenger;

public interface UpdatePassenger {

    Passenger execute(Long id, Passenger passenger);
}

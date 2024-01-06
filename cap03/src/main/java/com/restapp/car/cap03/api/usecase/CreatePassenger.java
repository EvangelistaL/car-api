package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.internal.entity.Passenger;

public interface CreatePassenger {

    Passenger execute(Passenger passenger);
}

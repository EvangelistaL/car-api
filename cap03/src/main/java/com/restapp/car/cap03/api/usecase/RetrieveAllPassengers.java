package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.internal.entity.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveAllPassengers {

    Page<Passenger> execute(Pageable pageable);
}

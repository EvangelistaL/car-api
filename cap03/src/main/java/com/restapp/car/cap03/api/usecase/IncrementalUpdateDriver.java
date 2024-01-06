package com.restapp.car.cap03.api.usecase;

import com.restapp.car.cap03.internal.entity.Driver;

public interface IncrementalUpdateDriver {

    Driver execute(Long id, Driver driver);
}

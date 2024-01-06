package com.restapp.car.cap03.api.controller;

import com.restapp.car.cap03.internal.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/drivers")
public interface DriverController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Driver> retrieveAllDrivers(Pageable pageable);

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Driver retrieveDriverById(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Driver createDriver(@RequestBody Driver driver);

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    Driver updateDriver(@PathVariable Long id, @RequestBody Driver driver);

    @PatchMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    Driver incrementalUpdateDriver(@PathVariable Long id, @RequestBody Driver driver);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDriverById(@PathVariable Long id);
}

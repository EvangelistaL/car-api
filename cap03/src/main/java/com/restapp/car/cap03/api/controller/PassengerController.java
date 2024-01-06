package com.restapp.car.cap03.api.controller;

import com.restapp.car.cap03.internal.entity.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/passengers")
public interface PassengerController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Passenger> retrieveAllPassengers(Pageable pageable);

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Passenger retrievePassengerById(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Passenger createPassenger(@RequestBody Passenger passenger);

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger);

    @PatchMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    Passenger incrementalUpdatePassenger(@PathVariable Long id, @RequestBody Passenger passenger);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePassengerById(@PathVariable Long id);
}

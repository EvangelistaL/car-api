package com.restapp.car.cap03.api.usecase;

public interface GoogleMapsService {

    Double consultDistanceBetweenAddresses(String location, String destination);
}

package com.restapp.car.cap03.internal.usecase;

import com.jayway.jsonpath.JsonPath;
import com.restapp.car.cap03.api.usecase.GoogleMapsService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DefaultGoogleMapsService implements GoogleMapsService {

    @Value("${gmaps.apiKey}")
    private String apiKey;

    private static final String GMAPS_TEMPLATE = "https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={destination}&key={key}";

    @Override
    public Double consultDistanceBetweenAddresses(String location, String destination) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(GMAPS_TEMPLATE, String.class, location, destination, apiKey);
        return resultParser(jsonResponse);
    }

    private Double resultParser(String jsonResponse){
        JSONArray raw = JsonPath.parse(jsonResponse).read("$..legs[*].duration.value");
        return raw.stream()
                .map(Double.class::cast)
                .min(Double::compareTo)
                .orElse(Double.MAX_VALUE);
    }
}

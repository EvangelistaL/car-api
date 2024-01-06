package com.restapp.car.cap03.internal.entity;

import com.restapp.car.cap03.internal.entity.enums.TravelRequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "travel_request")
public class TravelRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "travel_request_date")
    private LocalDateTime travelRequestDate;

    @Column(name = "travel_request_status")
    @Enumerated(EnumType.STRING)
    private TravelRequestStatus travelRequestStatus;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
}

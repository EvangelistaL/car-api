package com.restapp.car.cap03.internal.repository;

import com.restapp.car.cap03.internal.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>,
        QuerydslPredicateExecutor<Passenger> {
}

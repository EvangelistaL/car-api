package com.restapp.car.cap03.internal.repository;

import com.restapp.car.cap03.internal.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DriverRepository extends JpaRepository<Driver, Long>,
        QuerydslPredicateExecutor<Driver> {
}

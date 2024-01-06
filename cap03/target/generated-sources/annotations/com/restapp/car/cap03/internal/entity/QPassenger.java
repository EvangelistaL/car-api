package com.restapp.car.cap03.internal.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPassenger is a Querydsl query type for Passenger
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPassenger extends EntityPathBase<Passenger> {

    private static final long serialVersionUID = -767521473L;

    public static final QPassenger passenger = new QPassenger("passenger");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPassenger(String variable) {
        super(Passenger.class, forVariable(variable));
    }

    public QPassenger(Path<? extends Passenger> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPassenger(PathMetadata metadata) {
        super(Passenger.class, metadata);
    }

}


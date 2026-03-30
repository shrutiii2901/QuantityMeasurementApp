package com.app.quantitymeasurementapp.repository;

import com.app.quantitymeasurementapp.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {

    List<QuantityMeasurementEntity> findByOperation(String operation);

    // List<QuantityMeasurementEntity> findByThisMeasurementType(String type);

    List<QuantityMeasurementEntity> findByErrorTrue();

    long countByOperationAndErrorFalse(String operation);
}
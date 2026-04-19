package com.qm.measurement_service.repository;  

import com.qm.measurement_service.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {

    List<QuantityMeasurementEntity> findByOperation(String operation);

    List<QuantityMeasurementEntity> findByError(String error);

    long countByOperationAndError(String operation, String error);
}
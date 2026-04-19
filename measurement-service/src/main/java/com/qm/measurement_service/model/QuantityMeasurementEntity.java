package com.qm.measurement_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quantity_measurements")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private String operand1;
    private String operand2;
    private String result;
    private String error;

    private LocalDateTime createdAt;

    // ✅ Default constructor
    public QuantityMeasurementEntity() {}

    // ✅ Success constructor
    public QuantityMeasurementEntity(String operation, String operand1, String operand2, String result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.error = null; // important
    }

    // ✅ Error constructor
    public QuantityMeasurementEntity(String error) {
        this.error = error;
        this.operation = null;
        this.operand1 = null;
        this.operand2 = null;
        this.result = null;
    }

    // ✅ Auto timestamp
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // ✅ Helper
    public boolean hasError() {
        return error != null;
    }

    // ✅ GETTERS
    public Long getId() { return id; }

    public String getOperation() { return operation; }

    public String getOperand1() { return operand1; }

    public String getOperand2() { return operand2; }

    public String getResult() { return result; }

    public String getError() { return error; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    // ✅ SETTERS (important for JPA + flexibility)

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
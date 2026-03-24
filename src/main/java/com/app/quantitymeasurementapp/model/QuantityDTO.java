package com.app.quantitymeasurementapp.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuantityDTO {

    @NotNull
    private Double value;

    @NotNull
    private String unit;

    @NotNull
    private String measurementType;
}
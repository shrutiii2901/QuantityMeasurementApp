package com.app.quantitymeasurementapp.model;

import com.app.quantitymeasurementapp.quantity.Quantity;
import com.app.quantitymeasurementapp.measurable.IMeasurable;
import com.app.quantitymeasurementapp.units.*;

public class QuantityModel {
    public static Quantity<?> toQuantity(QuantityDTO dto) {

        switch(dto.getUnit()){
            case "FEET":
            case "INCH":
            case "YARDS":
            case "CENTIMETER": return new Quantity<>(dto.getValue(), LengthUnit.valueOf(dto.getUnit()));

            case "KILOGRAM":
            case "GRAM":
            case "POUND": return new Quantity<>(dto.getValue(), WeightUnit.valueOf(dto.getUnit()));

            case "LITRE":
            case "MILLILITRE":
            case "GALLON": return new Quantity<>(dto.getValue(), VolumeUnit.valueOf(dto.getUnit()));

            case "CELSIUS":
            case "FAHRENHEIT": return new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(dto.getUnit()));

            default: throw new IllegalArgumentException("Invalid unit");
        }
    }
}
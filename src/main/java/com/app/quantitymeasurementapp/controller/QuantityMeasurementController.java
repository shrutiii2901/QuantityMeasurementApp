package com.app.quantitymeasurementapp.controller;

import com.app.quantitymeasurementapp.model.QuantityDTO;
import com.app.quantitymeasurementapp.model.QuantityInputDTO;
import com.app.quantitymeasurementapp.model.QuantityMeasurementEntity;
import com.app.quantitymeasurementapp.quantity.Quantity;
import com.app.quantitymeasurementapp.service.IQuantityMeasurementService;
import com.app.quantitymeasurementapp.units.LengthUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityInputDTO input) {

        QuantityDTO q1 = input.getThisQuantityDTO();
        QuantityDTO q2 = input.getThatQuantityDTO();

        Quantity quantity1 = new Quantity(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));
        Quantity quantity2 = new Quantity(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return service.compare(quantity1, quantity2);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityInputDTO input) {
        QuantityDTO q1 = input.getThisQuantityDTO();
        QuantityDTO q2 = input.getThatQuantityDTO();

        Quantity quantity1 = new Quantity(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));
        Quantity quantity2 = new Quantity(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return service.add(quantity1, quantity2);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityInputDTO input) {
        QuantityDTO q1 = input.getThisQuantityDTO();
        QuantityDTO q2 = input.getThatQuantityDTO();

        Quantity quantity1 = new Quantity(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));
        Quantity quantity2 = new Quantity(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return service.subtract(quantity1, quantity2);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityInputDTO input) {
        QuantityDTO q1 = input.getThisQuantityDTO();
        QuantityDTO q2 = input.getThatQuantityDTO();

        Quantity quantity1 = new Quantity(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));
        Quantity quantity2 = new Quantity(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return service.convert(quantity1, quantity2);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityInputDTO input) {
        QuantityDTO q1 = input.getThisQuantityDTO();
        QuantityDTO q2 = input.getThatQuantityDTO();

        Quantity quantity1 = new Quantity(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));
        Quantity quantity2 = new Quantity(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return service.divide(quantity1, quantity2);
    }

}
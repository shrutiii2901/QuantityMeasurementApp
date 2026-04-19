package com.qm.measurement_service.controller;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qm.measurement_service.model.QuantityMeasurementEntity;
import com.qm.measurement_service.model.QuantityModel;
import com.qm.measurement_service.*;
import com.qm.measurement_service.model.QuantityDTO;
import com.qm.measurement_service.model.QuantityInputDTO;
import com.qm.measurement_service.quantity.Quantity;
import com.qm.measurement_service.service.IQuantityMeasurementService;

@RestController
@RequestMapping("/quantities")
public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    private QuantityMeasurementEntity process(QuantityInputDTO input, BiFunction<Quantity<?>, Quantity<?>, QuantityMeasurementEntity> operation) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());

        return operation.apply(q1, q2);
    }

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityInputDTO input) {
        return process(input, service::compare);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityInputDTO input) {
        return process(input, service::add);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityInputDTO input) {
        return process(input, service::subtract);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityInputDTO input) {
        return process(input, service::convert);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityInputDTO input) {
        return process(input, service::divide);
    }

    @GetMapping("/history/{operation}")
    public List<QuantityMeasurementEntity> getHistory(@PathVariable String operation) {
        return service.getHistoryByOperation(operation);
    }
}

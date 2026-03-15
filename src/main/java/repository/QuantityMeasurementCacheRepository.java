package repository;

import java.util.ArrayList;
import java.util.List;

import model.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {
    private final List<QuantityMeasurementEntity> storage = new ArrayList<>();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        storage.add(entity);
    }
}
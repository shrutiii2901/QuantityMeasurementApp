package app;

import controller.QuantityMeasurementController;
import model.QuantityMeasurementEntity;
import repository.IQuantityMeasurementRepository;
import repository.QuantityMeasurementDatabaseRepository;
import service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();

        QuantityMeasurementController controller = new QuantityMeasurementController(new QuantityMeasurementServiceImpl());

        QuantityMeasurementEntity entity
                = new QuantityMeasurementEntity("ADD", "5m", "10m", "15m");

        new QuantityMeasurementDatabaseRepository().save(entity);
    }
}

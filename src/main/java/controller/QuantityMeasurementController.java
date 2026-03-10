


public class QuantityMeasurementController {

    private QuantityMeasurementServiceImpl service =
            new QuantityMeasurementServiceImpl();

    public void performAddition() {

        QuantityDTO q1 = new QuantityDTO(10, "FEET");
        QuantityDTO q2 = new QuantityDTO(5, "FEET");

        QuantityDTO result = service.add(q1, q2);

        System.out.println("Addition Result: " + result.getValue());
    }
}
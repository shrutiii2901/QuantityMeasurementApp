public class QuantityMeasurementServiceImpl {

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        double result = q1.getValue() + q2.getValue();

        return new QuantityDTO(result, q1.getUnit());
    }

    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        double result = q1.getValue() - q2.getValue();

        return new QuantityDTO(result, q1.getUnit());
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {

        return q1.getValue() / q2.getValue();
    }
}
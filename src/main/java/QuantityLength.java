public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value or unit");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Addition Method
    public static QuantityLength add(QuantityLength q1, QuantityLength q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        // Convert both values to FEET
        double value1InFeet = q1.unit.toFeet(q1.value);
        double value2InFeet = q2.unit.toFeet(q2.value);

        // Add them
        double sumFeet = value1InFeet + value2InFeet;

        // Convert result back to unit of first operand
        double result = q1.unit.fromFeet(sumFeet);

        return new QuantityLength(result, q1.unit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
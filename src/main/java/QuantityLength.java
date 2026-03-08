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

    // -----------------------------
    // UC6: Addition (result in first operand unit)
    // -----------------------------
    public static QuantityLength add(QuantityLength q1, QuantityLength q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        return add(q1, q2, q1.unit);
    }

    // -----------------------------
    // UC7: Addition with Target Unit
    // -----------------------------
    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        // Convert both to FEET
        double q1Feet = q1.unit.toFeet(q1.value);
        double q2Feet = q2.unit.toFeet(q2.value);

        // Add
        double sumFeet = q1Feet + q2Feet;

        // Convert to target unit
        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
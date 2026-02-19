package com.quantity;
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    // Epsilon for floating-point comparison
    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Converts this QuantityLength to target unit.
     * @param targetUnit target unit to convert to
     * @return new QuantityLength instance in target unit
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        // Step 1: Convert current value to base unit (feet)
        double valueInFeet = this.value * this.unit.getConversionFactor();

        // Step 2: Convert from base unit to target unit
        double convertedValue = valueInFeet / targetUnit.getConversionFactor();

        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Static utility method for direct conversion between units.
     */
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");

        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;
        double thisInFeet = this.value * this.unit.getConversionFactor();
        double otherInFeet = other.value * other.unit.getConversionFactor();

        return Math.abs(thisInFeet - otherInFeet) < EPSILON;
    }

    @Override
    public String toString() {
        return String.format("%.6f %s", value, unit);
    }
}

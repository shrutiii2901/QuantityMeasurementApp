public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 0.000001;

    public QuantityWeight(double value, WeightUnit unit) {

        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid weight value or unit");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // -----------------------------
    // Convert to another unit
    // -----------------------------
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // -----------------------------
    // Addition (default unit)
    // -----------------------------
    public QuantityWeight add(QuantityWeight other) {

        return add(other, this.unit);
    }

    // -----------------------------
    // Addition (explicit target)
    // -----------------------------
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    // -----------------------------
    // Equality
    // -----------------------------
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue = unit.convertToBaseUnit(value);
        return Double.hashCode(baseValue);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
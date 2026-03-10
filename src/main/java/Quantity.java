
public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    private void validate(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException("Different measurement categories");
    }

    private double baseValue() {
        return unit.toBase(value);
    }

    public Quantity<U> convertTo(U targetUnit) {

        double base = baseValue();
        double converted = targetUnit.fromBase(base);

        return new Quantity<>(round(converted), targetUnit);
    }

    // ---------- ADDITION ----------
    public Quantity<U> add(Quantity<U> other) {

        validate(other);

        double result = baseValue() + other.baseValue();

        double finalValue = unit.fromBase(result);

        return new Quantity<>(round(finalValue), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validate(other);

        double result = baseValue() + other.baseValue();

        double finalValue = targetUnit.fromBase(result);

        return new Quantity<>(round(finalValue), targetUnit);
    }

    // ---------- UC12 SUBTRACTION ----------

    public Quantity<U> subtract(Quantity<U> other) {

        validate(other);

        double result = baseValue() - other.baseValue();

        double finalValue = unit.fromBase(result);

        return new Quantity<>(round(finalValue), unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        validate(other);

        double result = baseValue() - other.baseValue();

        double finalValue = targetUnit.fromBase(result);

        return new Quantity<>(round(finalValue), targetUnit);
    }

    // ---------- UC12 DIVISION ----------

    public double divide(Quantity<U> other) {

        validate(other);

        double divisor = other.baseValue();

        if (Math.abs(divisor) < EPSILON)
            throw new ArithmeticException("Division by zero");

        return baseValue() / divisor;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Quantity<?> q))
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (unit.getClass() != other.unit.getClass())
            return false;

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
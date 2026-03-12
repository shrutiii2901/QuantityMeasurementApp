
import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.01;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

   

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(base);

        return new Quantity<>(round(converted), targetUnit);
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        if (this.unit.getClass() != other.unit.getClass())
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = ((IMeasurable) other.unit).convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }



    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0)
                throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public double compute(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
    }

    private double performArithmetic(Quantity<U> other,
                                     ArithmeticOperation operation) {

        unit.validateOperationSupport(operation.name());

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return operation.compute(base1, base2);
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

   

    public Quantity<U> add(Quantity<U> other) {

        double resultBase = performArithmetic(other, ArithmeticOperation.ADD);

        double converted = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(round(converted), unit);
    }


    public Quantity<U> subtract(Quantity<U> other) {

        double resultBase = performArithmetic(other, ArithmeticOperation.SUBTRACT);

        double converted = unit.convertFromBaseUnit(resultBase);

        return new Quantity<>(round(converted), unit);
    }

    public double divide(Quantity<U> other) {

        return performArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
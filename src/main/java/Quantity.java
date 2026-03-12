public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.000001;

    public Quantity(double value, U unit) {

        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid quantity value or unit");
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

  

    
    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(round(converted), targetUnit);
    }

    
 
    public Quantity<U> add(Quantity<U> other) {

        return add(other, this.unit);
    }

    
    
    
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(round(result), targetUnit);
    }

   
   
   
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

       
        if (this.unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue = unit.convertToBaseUnit(value);
        return Double.hashCode(baseValue);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}
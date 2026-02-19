// Enum for Length Units
enum LengthUnit {
    FEET(1.0),                // Base unit: FEET
    INCHES(1.0 / 12.0),       // 1 inch = 1/12 feet
    YARDS(3.0),               // 1 yard = 3 feet
    CENTIMETERS(0.393701 / 12); // 1 cm = 0.393701 inches = 0.393701/12 feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}

// Generic QuantityLength Class
class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double convertToFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Reflexive
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.convertToFeet(), other.convertToFeet()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(convertToFeet()).hashCode();
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}

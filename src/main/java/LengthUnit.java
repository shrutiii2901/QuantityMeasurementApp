public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double toBaseFactor;

    LengthUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toBaseFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }
}
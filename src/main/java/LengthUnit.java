public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toFeet(double value) {
        return value * conversionFactor;
    }

    public double fromFeet(double feetValue) {
        return feetValue / conversionFactor;
    }
}
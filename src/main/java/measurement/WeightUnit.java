public enum WeightUnit implements IMeasurable {

    GRAM(1.0),
    KILOGRAM(1000.0);

    private final double toGram;

    WeightUnit(double toGram) {
        this.toGram = toGram;
    }

    public double convertToBaseUnit(double value) {
        return value * toGram;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toGram;
    }
}
public enum WeightUnit implements IMeasurable {

    KILOGRAM(1000),
    GRAM(1);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBase(double value) {
        return value * conversionFactor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / conversionFactor;
    }
}
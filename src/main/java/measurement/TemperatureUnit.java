public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    public double convertToBaseUnit(double value) {

        switch (this) {
            case CELSIUS: return value;
            case FAHRENHEIT: return (value - 32) * 5 / 9;
            case KELVIN: return value - 273.15;
        }

        return value;
    }

    public double convertFromBaseUnit(double baseValue) {

        switch (this) {
            case CELSIUS: return baseValue;
            case FAHRENHEIT: return (baseValue * 9 / 5) + 32;
            case KELVIN: return baseValue + 273.15;
        }

        return baseValue;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation
        );
    }
}
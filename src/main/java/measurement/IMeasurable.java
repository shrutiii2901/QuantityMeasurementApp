public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    default void validateOperationSupport(String operation) {
        // default allowed
    }
}
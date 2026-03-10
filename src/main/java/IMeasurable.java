
public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    // Default lambda for arithmetic support
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Default validation (all units allow arithmetic unless overridden)
    default void validateOperationSupport(String operation) {
        // default: do nothing
    }
}
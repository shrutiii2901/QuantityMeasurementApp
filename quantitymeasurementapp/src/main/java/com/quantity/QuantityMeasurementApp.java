package com.quantity;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        QuantityLength length = new QuantityLength(value, fromUnit);
        QuantityLength converted = length.convertTo(toUnit);
        System.out.printf("%.6f %s = %.6f %s%n", value, fromUnit, converted.getValue(), toUnit);
    }


    public static void demonstrateLengthConversion(QuantityLength length, LengthUnit targetUnit) {
        QuantityLength converted = length.convertTo(targetUnit);
        System.out.printf("%s = %.6f %s%n", length, converted.getValue(), targetUnit);
    }

    public static void demonstrateLengthEquality(QuantityLength a, QuantityLength b) {
        System.out.printf("%s and %s are %s%n", a, b, a.equals(b) ? "equal" : "not equal");
    }

    public static void main(String[] args) {
       
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(-1.0, LengthUnit.FEET, LengthUnit.INCHES);

        // Equality checks
        QuantityLength len1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength len2 = new QuantityLength(3.0, LengthUnit.FEET);
        demonstrateLengthEquality(len1, len2);
    }
}

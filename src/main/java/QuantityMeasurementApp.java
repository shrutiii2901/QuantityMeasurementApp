
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateSubtraction();
        demonstrateDivision();
    }

    private static void demonstrateSubtraction() {

        System.out.println("---- SUBTRACTION ----");

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(6, LengthUnit.INCHES);

        System.out.println(a.subtract(b));

        Quantity<WeightUnit> w1 =
                new Quantity<>(10, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000, WeightUnit.GRAM);

        System.out.println(w1.subtract(w2));

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println(v1.subtract(v2));
    }

    private static void demonstrateDivision() {

        System.out.println("---- DIVISION ----");

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2, LengthUnit.FEET);

        System.out.println(a.divide(b));

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(10, VolumeUnit.LITRE);

        System.out.println(v1.divide(v2));
    }
}
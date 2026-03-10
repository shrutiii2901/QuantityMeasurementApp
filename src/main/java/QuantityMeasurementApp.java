public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Addition: " + q1.add(q2));

        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("Weight Add: " + w1.add(w2, WeightUnit.GRAM));

        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        System.out.println("Subtract: " + v1.subtract(v2));

        Quantity<LengthUnit> d1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> d2 = new Quantity<>(2.0, LengthUnit.FEET);

        System.out.println("Divide: " + d1.divide(d2));
    }
}
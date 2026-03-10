
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("Equality: " + t1.equals(t2));

        Quantity<TemperatureUnit> converted =
                t1.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("Converted: " + converted);

        try {

            t1.add(new Quantity<>(50, TemperatureUnit.CELSIUS));

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
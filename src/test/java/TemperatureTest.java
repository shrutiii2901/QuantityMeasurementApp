import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TemperatureTest {

    @Test
    void testCelsiusToFahrenheitEquality() {

        Quantity<TemperatureUnit> c =
                new Quantity<>(0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        assertTrue(c.equals(f));
    }

    @Test
    void testCelsiusToKelvinEquality() {

        Quantity<TemperatureUnit> c =
                new Quantity<>(0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> k =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        assertTrue(c.equals(k));
    }

    @Test
    void testConversion() {

        Quantity<TemperatureUnit> c =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                c.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, f.getValue());
    }

    @Test
    void testUnsupportedAddition() {

        Quantity<TemperatureUnit> c =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> c.add(new Quantity<>(50, TemperatureUnit.CELSIUS))
        );
    }

    @Test
    void testUnsupportedDivision() {

        Quantity<TemperatureUnit> c =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> c.divide(new Quantity<>(50, TemperatureUnit.CELSIUS))
        );
    }
}
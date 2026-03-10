
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class QuantityTest {

    @Test
    void testSubtractionSameUnit() {

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(5.0, result.getValue());
    }

    @Test
    void testSubtractionCrossUnit() {

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(6, LengthUnit.INCHES);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(9.5, result.getValue());
    }

    @Test
    void testSubtractionNegative() {

        Quantity<LengthUnit> a =
                new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(-5.0, result.getValue());
    }

    @Test
    void testDivisionSameUnit() {

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2, LengthUnit.FEET);

        assertEquals(5.0, a.divide(b));
    }

    @Test
    void testDivisionCrossUnit() {

        Quantity<LengthUnit> a =
                new Quantity<>(24, LengthUnit.INCHES);

        Quantity<LengthUnit> b =
                new Quantity<>(2, LengthUnit.FEET);

        assertEquals(1.0, a.divide(b));
    }

    @Test
    void testDivisionByZero() {

        Quantity<LengthUnit> a =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> a.divide(b));
    }
}
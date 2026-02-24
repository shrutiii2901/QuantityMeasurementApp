import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityLengthTest {

    @Test
    public void testEquality_YardToYard_SameValue() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength q2 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertEquals(q1, q2);
    }


    @Test
    public void testEquality_YardToFeet() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength q2 =
                new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(q1, q2);
    }


    @Test
    public void testEquality_YardToInches() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength q2 =
                new QuantityLength(36.0, LengthUnit.INCHES);

        assertEquals(q1, q2);
    }


    @Test
    public void testEquality_CentimeterToCentimeter() {

        QuantityLength q1 =
                new QuantityLength(2.0, LengthUnit.CENTIMETERS);

        QuantityLength q2 =
                new QuantityLength(2.0, LengthUnit.CENTIMETERS);

        assertEquals(q1, q2);
    }


    @Test
    public void testEquality_CentimeterToInches() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        QuantityLength q2 =
                new QuantityLength(0.393701, LengthUnit.INCHES);

        assertEquals(q1, q2);
    }


    @Test
    public void testEquality_CentimeterToFeet_NotEqual() {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        QuantityLength q2 =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }


    @Test
    public void testEquality_MultiUnit() {

        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }


    @Test
    public void testEquality_NullComparison() {

        QuantityLength q =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertNotEquals(q, null);
    }


    @Test
    public void testEquality_SameReference() {

        QuantityLength q =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertEquals(q, q);
    }


    @Test
    public void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }


    @Test
    public void testEquality_AllUnitsComplex() {

        QuantityLength yard =
                new QuantityLength(2.0, LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(6.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(72.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

}
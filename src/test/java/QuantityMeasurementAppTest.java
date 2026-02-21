
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

 
    @Test
    public void testConversion_FeetToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = QuantityLength.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    // 2️⃣ Yards ↔ Inches
    @Test
    public void testConversion_YardsToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES);
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = QuantityLength.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON);
    }

   
    @Test
    public void testConversion_CentimetersToInches() {
        double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertEquals(1.0, result, EPSILON);
    }

   
    @Test
    public void testConversion_FeatToYard() {
        double result = QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double value = 5.0;
        double converted = QuantityLength.convert(value, LengthUnit.FEET, LengthUnit.INCHES);
        double back = QuantityLength.convert(converted, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(value, back, EPSILON);
    }

   
    @Test
    public void testConversion_ZeroValue() {
        double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(0.0, result, EPSILON);
    }

    // 7️⃣ Negative value conversion
    @Test
    public void testConversion_NegativeValue() {
        double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(-12.0, result, EPSILON);
    }

  
    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(1.0, null, LengthUnit.FEET));
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(1.0, LengthUnit.FEET, null));
    }

    
    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.NEGATIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
    }

   
    @Test
    public void testQuantityLengthEquality() {
        QuantityLength len1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength len2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength len3 = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength len4 = new QuantityLength(2.0, LengthUnit.FEET);

        assertEquals(len1, len2);
        assertEquals(len2, len3);
        assertNotEquals(len1, len4);
    }
}



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class QuantityMeasurementAppTest {

  

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkFeetEquality(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        Feet feet = new Feet(1.0);
        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        Feet feet = new Feet(1.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        Feet feet = new Feet(1.0);
        assertFalse(feet.equals("Invalid"));
    }

   

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkInchesEquality(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkInchesEquality(1.0, 2.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        Inches inches = new Inches(1.0);
        assertFalse(inches.equals(null));
    }

    @Test
    void testInchesEquality_SameReference() {
        Inches inches = new Inches(1.0);
        assertTrue(inches.equals(inches));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        Inches inches = new Inches(1.0);
        assertFalse(inches.equals(100));
    }
}

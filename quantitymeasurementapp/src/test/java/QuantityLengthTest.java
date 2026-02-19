import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuantityLengthTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(0.393701, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCHES);

        assertEquals(q1, q2);
        assertEquals(q2, q3);
        assertEquals(q1, q3);
    }

    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityLength(1.0, null));
    }

    @Test
    void testEquality_YardSameReference() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertEquals(q1, q1);
    }

    @Test
    void testEquality_YardNullComparison() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertNotEquals(q1, null);
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        QuantityLength qYard = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength qFeet = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength qInches = new QuantityLength(72.0, LengthUnit.INCHES);

        assertEquals(qYard, qFeet);
        assertEquals(qFeet, qInches);
        assertEquals(qYard, qInches);
    }

}

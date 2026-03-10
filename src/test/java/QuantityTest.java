import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    private static final double EPS = 0.001;

    // -----------------------------
    // Length Equality Tests
    // -----------------------------

    @Test
    void testLengthEquality_FeetToInches() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testLengthEquality_SameUnit() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    // -----------------------------
    // Weight Equality Tests
    // -----------------------------

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testWeightEquality_KgToPound() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(2.20462, WeightUnit.POUND);

        assertTrue(w1.equals(w2));
    }

    // -----------------------------
    // Length Conversion Tests
    // -----------------------------

    @Test
    void testLengthConversion_FeetToInches() {

        Quantity<LengthUnit> q =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPS);
    }

    @Test
    void testLengthConversion_InchesToFeet() {

        Quantity<LengthUnit> q =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q.convertTo(LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPS);
    }

    // -----------------------------
    // Weight Conversion Tests
    // -----------------------------

    @Test
    void testWeightConversion_KgToGram() {

        Quantity<WeightUnit> q =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPS);
    }

    @Test
    void testWeightConversion_PoundToKg() {

        Quantity<WeightUnit> q =
                new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result =
                q.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPS);
    }

    // -----------------------------
    // Length Addition Tests
    // -----------------------------

    @Test
    void testLengthAddition_FeetPlusInches() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPS);
    }

    // -----------------------------
    // Weight Addition Tests
    // -----------------------------

    @Test
    void testWeightAddition_KgPlusGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                w1.add(w2, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), EPS);
    }

    // -----------------------------
    // Cross Category Comparison
    // -----------------------------

    @Test
    void testCrossCategoryComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // -----------------------------
    // Constructor Validation
    // -----------------------------

    @Test
    void testConstructor_NullUnit() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(1.0, null);
        });
    }

    @Test
    void testConstructor_InvalidValue() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(Double.NaN, LengthUnit.FEET);
        });
    }

}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    private static final double EPS = 0.0001;

    @Test
    void testEquality_KilogramToGram() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testEquality_KilogramToPound() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testConversion_KilogramToGram() {

        QuantityWeight w = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight result = w.convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), EPS);
    }

    @Test
    void testConversion_PoundToKilogram() {

        QuantityWeight w = new QuantityWeight(2.20462, WeightUnit.POUND);

        QuantityWeight result = w.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1, result.getValue(), EPS);
    }

    @Test
    void testAddition_KgPlusGram() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight result = w1.add(w2);

        assertEquals(2, result.getValue(), EPS);
    }

    @Test
    void testAddition_TargetUnitGram() {

        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight result = w1.add(w2, WeightUnit.GRAM);

        assertEquals(2000, result.getValue(), EPS);
    }
}
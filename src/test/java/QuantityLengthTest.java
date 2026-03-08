import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class QuantityLengthTest {

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.001);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(q1, q2, null);
        });
    }
}

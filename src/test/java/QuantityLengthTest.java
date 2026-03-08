import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class QuantityLengthTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(3.0, result.getValue(), 0.001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(2.0, result.getValue(), 0.001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength q1 = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(5.0, result.getValue(), 0.001);
    }
}
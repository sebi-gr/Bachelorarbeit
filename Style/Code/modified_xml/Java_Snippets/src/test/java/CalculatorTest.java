import org.junit.Assert;
import org.junit.Test;
import testing.Calculator;

/**
 * This class contains unit tests for the Calculator class.
 */
public class CalculatorTest {

    /**
     * Tests the add method.
     */
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        Assert.assertEquals(5, result);
    }
}
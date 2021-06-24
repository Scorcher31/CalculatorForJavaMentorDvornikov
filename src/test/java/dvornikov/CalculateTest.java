package dvornikov;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {
    @Test
    public void add() {
        Calculate calc = new Calculate();
        assertEquals(15, calc.add(5, 10));
    }

    @Test
    public void subtract() {
        Calculate calc = new Calculate();
        assertEquals(15, calc.subtract(20, 5));
    }

    @Test
    public void multiply() {
        Calculate calc = new Calculate();
        assertEquals(50, calc.multiply(5, 10));
    }

    @Test(expected = ArithmeticException.class)
    public void divide() throws ArithmeticException{
        Calculate calc = new Calculate();
        calc.add(5, 0);
    }
}
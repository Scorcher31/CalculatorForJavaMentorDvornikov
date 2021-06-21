package dvornikov;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

    @org.junit.Test
    public void testAdd() throws Exception{
        assertEquals(15, Calculate.add(5,10));
    }

    @org.junit.Test
    public void testSubtract() throws Exception{
        assertEquals(-5, Calculate.subtract(5,10));
    }

    @org.junit.Test
    public void testMultiply() throws Exception{
        assertEquals(50, Calculate.multiply(5,10));
    }

    @org.junit.Test
    public void testDivide() throws Exception{
        assertEquals(2, Calculate.divide(10,5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void divideWithException() throws Exception{
        Calculate.divide(5, 0);
    }
}
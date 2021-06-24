package dvornikov;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RomanToArabicConverterTest {
    @Test
    public void isRomanNumber() {
        assertEquals(true, RomanToArabicConverter.isRomanNumber("XiX"));
    }

    @Test
    public void isRomanNumberf() {
        assertEquals(false, RomanToArabicConverter.isRomanNumber("167"));
    }

    @Test
    public void isArabicNumber() {
        assertEquals(true, RomanToArabicConverter.isArabicNumber("1567"));
    }

    @Test
    public void isArabicNumberf() {
        assertEquals(false, RomanToArabicConverter.isArabicNumber("XXX"));
    }

    @Test
    public void translateToArabicNumericals1438() {
        try {
            assertEquals("1438", RomanToArabicConverter.RomanToArabic("MCDXXXVIII"));
        } catch(CalculatorException cex) {
            cex.printStackTrace();
        }
    }

    @Test
    public void translateToArabicNumericals3333() {
        try {
            assertEquals("3333", RomanToArabicConverter.RomanToArabic("MMMCCCXXXIII"));
        } catch(CalculatorException cex) {
            cex.printStackTrace();
        }
    }

    @Test
    public void translateToArabicNumericals949() {
        try {
            assertEquals("949", RomanToArabicConverter.RomanToArabic("CMXLIX"));
        } catch(CalculatorException cex) {
            cex.printStackTrace();
        }
    }

    @Test
    public void translateToArabicNumericals7() {
        try {
            assertEquals("7", RomanToArabicConverter.RomanToArabic("VII"));
        } catch(CalculatorException cex) {
            cex.printStackTrace();
        }
    }

    @Test(expected = CalculatorException.class)
    public void translateToArabicNumericalsExc() throws CalculatorException {
        RomanToArabicConverter.RomanToArabic("VIIIMMMM");
    }

    @Test
    public void arabicToRoman1998() {
        assertEquals("MCMXCVIII", RomanToArabicConverter.arabicToRoman(1998));
    }

    @Test
    public void arabicToRoman1998m() {
        assertEquals("-MCMXCVIII", RomanToArabicConverter.arabicToRoman(-1998));
    }
}
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSingleValues() {
        assertEquals(1, RomanNumeralConverter.toValue("I"));
        assertEquals(5, RomanNumeralConverter.toValue("V"));
        assertEquals(10, RomanNumeralConverter.toValue("X"));
        assertEquals(50, RomanNumeralConverter.toValue("L"));
        assertEquals(100, RomanNumeralConverter.toValue("C"));
        assertEquals(500, RomanNumeralConverter.toValue("D"));
        assertEquals(1000, RomanNumeralConverter.toValue("M"));
    }

    @Test
    public void testRepeatableValues() {
        assertEquals(2, RomanNumeralConverter.toValue("II"));
        assertEquals(20, RomanNumeralConverter.toValue("XX"));
        assertEquals(200, RomanNumeralConverter.toValue("CC"));
        assertEquals(2000, RomanNumeralConverter.toValue("MM"));
    }

    @Test
    public void testNonRepeatableValues() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat V");
        RomanNumeralConverter.toValue("VV");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat L");
        RomanNumeralConverter.toValue("LL");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat D");
        RomanNumeralConverter.toValue("DD");
    }

    @Test
    public void testSubtractionUsingI() {
        assertEquals(4, RomanNumeralConverter.toValue("IV"));
        assertEquals(9, RomanNumeralConverter.toValue("IX"));

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before L");
        RomanNumeralConverter.toValue("IL");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before C");
        RomanNumeralConverter.toValue("IC");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before D");
        RomanNumeralConverter.toValue("ID");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before M");
        RomanNumeralConverter.toValue("IM");
    }

    @Test
    public void testSubtractionUsingV() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before X");
        RomanNumeralConverter.toValue("VX");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before L");
        RomanNumeralConverter.toValue("VL");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before C");
        RomanNumeralConverter.toValue("VC");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before D");
        RomanNumeralConverter.toValue("VD");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before M");
        RomanNumeralConverter.toValue("VM");
    }

    @Test
    public void testSubtractionUsingX() {
        assertEquals(40, RomanNumeralConverter.toValue("XL"));
        assertEquals(90, RomanNumeralConverter.toValue("XC"));

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use X before D");
        RomanNumeralConverter.toValue("XD");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use X before M");
        RomanNumeralConverter.toValue("XM");
    }

    @Test
    public void testSubtractionUsingL() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before C");
        RomanNumeralConverter.toValue("LC");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before D");
        RomanNumeralConverter.toValue("LD");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before M");
        RomanNumeralConverter.toValue("LM");
    }

    @Test
    public void testSubtractionUsingC() {
        assertEquals(400, RomanNumeralConverter.toValue("CD"));
        assertEquals(900, RomanNumeralConverter.toValue("CM"));
    }

    @Test
    public void testIII() {
        int value = RomanNumeralConverter.toValue("III");

        assertEquals(3, value);
    }

    @Test
    public void testIIII() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat I more than 3 times in a row");
        RomanNumeralConverter.toValue("IIII");
    }

    @Test
    public void testXCV() {
        int value = RomanNumeralConverter.toValue("XCV");

        assertEquals(95, value);
    }

    @Test
    public void testXXXIX() {
        int value = RomanNumeralConverter.toValue("XXXIX");

        assertEquals(39, value);
    }
}

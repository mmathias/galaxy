import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NumberParserTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSingleValues() {
        assertEquals(1, NumberParser.toValue("I"));
        assertEquals(5, NumberParser.toValue("V"));
        assertEquals(10, NumberParser.toValue("X"));
        assertEquals(50, NumberParser.toValue("L"));
        assertEquals(100, NumberParser.toValue("C"));
        assertEquals(500, NumberParser.toValue("D"));
        assertEquals(1000, NumberParser.toValue("M"));
    }

    @Test
    public void testRepeatableValues() {
        assertEquals(2, NumberParser.toValue("II"));
        assertEquals(20, NumberParser.toValue("XX"));
        assertEquals(200, NumberParser.toValue("CC"));
        assertEquals(2000, NumberParser.toValue("MM"));
    }

    @Test
    public void testNonRepeatableValues() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat V");
        NumberParser.toValue("VV");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat L");
        NumberParser.toValue("LL");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't repeat D");
        NumberParser.toValue("DD");
    }

    @Test
    public void testSubtractionUsingI() {
        assertEquals(4, NumberParser.toValue("IV"));
        assertEquals(9, NumberParser.toValue("IX"));

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before L");
        NumberParser.toValue("IL");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before C");
        NumberParser.toValue("IC");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before D");
        NumberParser.toValue("ID");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use I before M");
        NumberParser.toValue("IM");
    }

    @Test
    public void testSubtractionUsingV() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before X");
        NumberParser.toValue("VX");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before L");
        NumberParser.toValue("VL");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before C");
        NumberParser.toValue("VC");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before D");
        NumberParser.toValue("VD");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use V before M");
        NumberParser.toValue("VM");
    }

    @Test
    public void testSubtractionUsingX() {
        assertEquals(40, NumberParser.toValue("XL"));
        assertEquals(90, NumberParser.toValue("XC"));

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use X before D");
        NumberParser.toValue("XD");
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use X before M");
        NumberParser.toValue("XM");
    }

    @Test
    public void testSubtractionUsingL() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before C");
        NumberParser.toValue("LC");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before D");
        NumberParser.toValue("LD");

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("You can't use L before M");
        NumberParser.toValue("LM");
    }

    @Test
    public void testSubtractionUsingC() {
        assertEquals(400, NumberParser.toValue("CD"));
        assertEquals(900, NumberParser.toValue("CM"));
    }

    @Test
    public void testIII() {
        int value = NumberParser.toValue("III");

        assertEquals(3, value);
    }

    @Test
    @Ignore
    public void testIIII() {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("You can't repeat I 4 times");
        NumberParser.toValue("IIII");
    }

    @Test
    public void testXCV() {
        int value = NumberParser.toValue("XCV");

        assertEquals(95, value);
    }

    @Test
    public void testXXXIX() {
        int value = NumberParser.toValue("XXXIX");

        assertEquals(39, value);
    }
}

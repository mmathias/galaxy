package romanNumerals;

import java.util.Arrays;
import java.util.List;

public class X extends RomanNumeral {

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public Character getSymbol() {
        return 'X';
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public List<Character> getSymbolsThatCanComeAfter() {
        return Arrays.asList('I', 'V', 'L', 'C');
    }
}

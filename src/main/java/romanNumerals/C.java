package romanNumerals;

import java.util.Arrays;
import java.util.List;

public class C extends RomanNumeral {

    @Override
    public int getValue() {
        return 100;
    }

    @Override
    public Character getSymbol() {
        return 'C';
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public List<Character> getSymbolsThatCanComeAfter() {
        return Arrays.asList('I', 'V', 'X', 'L', 'D', 'M');
    }
}

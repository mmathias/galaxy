package romanNumerals;

import java.util.Arrays;
import java.util.List;

public class I extends RomanNumeral {

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public Character getSymbol() {
        return 'I';
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public List<Character> getSymbolsThatCanComeAfter() {
        return Arrays.asList('V', 'X');
    }
}

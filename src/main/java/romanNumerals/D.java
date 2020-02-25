package romanNumerals;

import java.util.Collections;
import java.util.List;

public class D extends RomanNumeral {

    @Override
    public int getValue() {
        return 500;
    }

    @Override
    public Character getSymbol() {
        return 'D';
    }

    @Override
    public boolean isRepeatable() {
        return false;
    }

    @Override
    public List<Character> getSymbolsThatCanComeAfter() {
        return Collections.emptyList();
    }
}

package romanNumerals;

import java.util.Collections;
import java.util.List;

public class V extends RomanNumeral {

    @Override
    public int getValue() {
        return 5;
    }

    @Override
    public Character getSymbol() {
        return 'V';
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

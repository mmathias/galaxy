package romanNumerals;

import java.util.Collections;
import java.util.List;

public class M extends RomanNumeral {

    @Override
    public int getValue() {
        return 1000;
    }

    @Override
    public Character getSymbol() {
        return 'M';
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public List<Character> getSymbolsThatCanComeAfter() {
        return Collections.emptyList();
    }
}

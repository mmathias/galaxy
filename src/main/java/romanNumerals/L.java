package romanNumerals;

import java.util.Collections;
import java.util.List;

public class L extends RomanNumeral {

    @Override
    public int getValue() {
        return 50;
    }

    @Override
    public Character getSymbol() {
        return 'L';
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

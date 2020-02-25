package romanNumerals;

import java.util.List;

public abstract class RomanNumeral {
    private int occurrences = 1;

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public int getOccurrences() {
        return this.occurrences;
    }

    public abstract int getValue();
    public abstract Character getSymbol();
    public abstract boolean isRepeatable();
    public abstract List<Character> getSymbolsThatCanComeAfter();
}

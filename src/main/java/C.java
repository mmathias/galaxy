import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C implements Symbol {

    @Override
    public int getValue() {
        return 100;
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

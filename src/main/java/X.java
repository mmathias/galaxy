import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class X implements Symbol {

    @Override
    public int getValue() {
        return 10;
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

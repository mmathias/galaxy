import java.util.Collections;
import java.util.List;

public class L implements Symbol {

    @Override
    public int getValue() {
        return 50;
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

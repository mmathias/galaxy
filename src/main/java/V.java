import java.util.Collections;
import java.util.List;

public class V implements Symbol {

    @Override
    public int getValue() {
        return 5;
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

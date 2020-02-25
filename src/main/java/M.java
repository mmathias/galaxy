import java.util.Collections;
import java.util.List;

public class M implements Symbol {

    @Override
    public int getValue() {
        return 1000;
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

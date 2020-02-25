import java.util.List;

public interface Symbol {
    int getValue();
    boolean isRepeatable();
    List<Character> getSymbolsThatCanComeAfter();
}

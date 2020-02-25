import java.util.*;

public class NumberParser {

    private static Map<Character, Symbol> symbolDictionary =
            Map.of(
                    'I', new I(),
                    'V', new V(),
                    'X', new X(),
                    'L', new L(),
                    'C', new C(),
                    'D', new D(),
                    'M', new M());

    public static int toValue(String input) throws RuntimeException {
        char[] characters = input.toCharArray();
        Map<Character, Integer> characterCounter = createMapWithSymbolsAndTheirAppearances(characters);
        System.out.println(characterCounter);

        int sum = 0;

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            Symbol symbol = symbolDictionary.get(character);

            if (i + 1 < characters.length && character == characters[i+1] && !symbol.isRepeatable()) {
                throw new RuntimeException("You can't repeat " + character);
            }

            if (i + 1 < characters.length && character != characters[i+1] && !symbol.getSymbolsThatCanComeAfter().contains(characters[i+1])) {
                throw new RuntimeException("You can't use " + character + " before " + characters[i+1]);
            }

            if (i + 1 < characters.length && symbol.getValue() < symbolDictionary.get(characters[i + 1]).getValue()) {
                sum -= symbol.getValue();
            } else {
                sum += symbol.getValue();
            }
        }

        return sum;
    }

    private static LinkedHashMap<Character, Integer> createMapWithSymbolsAndTheirAppearances(char[] input) {
        LinkedHashMap<Character, Integer> characterCounter = new LinkedHashMap<>();
        int counter;

        for (char symbol : input) {
            if (characterCounter.containsKey(symbol)) {
                counter = characterCounter.get(symbol) + 1;
                characterCounter.put(symbol, counter);
            } else {
                characterCounter.put(symbol, 1);
            }
        }

        return characterCounter;
    }
}

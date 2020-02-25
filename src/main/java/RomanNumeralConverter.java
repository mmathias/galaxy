import romanNumerals.RomanNumeral;

import java.util.*;

public class RomanNumeralConverter {

    public static int toValue(String input) throws RuntimeException {
        char[] characters = input.toCharArray();

        // Create a list of symbols and its occurrences
        List<RomanNumeral> summary = createListOfSymbolsAndItsOccurrences(characters);

        return convertRomansIntoNumerals(summary);
    }

    private static int convertRomansIntoNumerals(List<RomanNumeral> summary) {
        int sum = 0;

        for (int i = 0; i < summary.size(); i++) {
            RomanNumeral romanNumeral = summary.get(i);

            validate(summary, i);

            if ((i + 1) < summary.size() && romanNumeral.getValue() < summary.get(i + 1).getValue()) {
                sum -= romanNumeral.getValue();
            } else {
                sum += romanNumeral.getValue() * summary.get(i).getOccurrences();
            }
        }

        return sum;
    }

    private static void validate(List<RomanNumeral> summary, int currentIndex) {
        RomanNumeral romanNumeral = summary.get(currentIndex);

        if (romanNumeral.getOccurrences() > 3) {
            throw new RuntimeException("You can't repeat " + romanNumeral.getSymbol() + " more than 3 times in a row");
        }

        if (romanNumeral.getOccurrences() > 1 && !romanNumeral.isRepeatable()) {
            throw new RuntimeException("You can't repeat " + romanNumeral.getSymbol());
        }

        if (currentIndex + 1 < summary.size()) {
            char nextCharacter = summary.get(currentIndex + 1).getSymbol();

            if (!romanNumeral.getSymbolsThatCanComeAfter().contains(nextCharacter)) {
                throw new RuntimeException("You can't use " + romanNumeral.getSymbol() + " before " + nextCharacter);
            }
        }
    }

    private static List<RomanNumeral> createListOfSymbolsAndItsOccurrences(char[] input) {
        List<RomanNumeral> summary = new ArrayList<>();
        RomanNumeral currentRomanNumeral = RomanNumeralFactory.createSymbol(input[0]);
        summary.add(currentRomanNumeral);

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i-1]) {
                currentRomanNumeral.setOccurrences(currentRomanNumeral.getOccurrences() + 1);
            } else {
                currentRomanNumeral = RomanNumeralFactory.createSymbol(input[i]);
                summary.add(currentRomanNumeral);
            }
        }

        return summary;
    }
}

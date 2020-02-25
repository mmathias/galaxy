import romanNumerals.*;

public class RomanNumeralFactory {
    public static RomanNumeral createSymbol(Character symbolInput) {
        RomanNumeral romanNumeral;

        switch (symbolInput) {
            case 'I': romanNumeral = new I(); break;
            case 'V': romanNumeral = new V(); break;
            case 'X': romanNumeral = new X(); break;
            case 'L': romanNumeral = new L(); break;
            case 'C': romanNumeral = new C(); break;
            case 'D': romanNumeral = new D(); break;
            case 'M': romanNumeral = new M(); break;
            default: throw new RuntimeException("Symbol not found.");
        }

        return romanNumeral;
    }
}

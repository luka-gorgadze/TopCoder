import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KingSort {

    private String firstDigitToRomanNumeral(int digit) {
        switch (digit) {
            case 0: {
                return "";
            }
            case 1: {
                return "I";
            }
            case 2: {
                return "II";
            }
            case 3: {
                return "III";
            }
            case 4: {
                return "IV";
            }
            case 5: {
                return "V";
            }
            case 6: {
                return "VI";
            }
            case 7: {
                return "VII";
            }
            case 8: {
                return "VIII";
            }
            case 9: {
                return "IX";
            }
        }
        return null;
    }

    private String secondDigitToRomanNumeral(int digit) {
        switch (digit) {
            case 0: {
                return "";
            }
            case 1: {
                return "X";
            }
            case 2: {
                return "XX";
            }
            case 3: {
                return "XXX";
            }
            case 4: {
                return "XL";
            }
            case 5: {
                return "L";
            }
        }
        return null;
    }

    private Map<String, Integer> numberToRomanNumeralMap() {
        Map<String, Integer> numberToRomanNumberal = new HashMap<>();
        for (int i = 1; i <= 50; i++) {
            System.out.println(secondDigitToRomanNumeral(i / 10) + firstDigitToRomanNumeral(i % 10));
            numberToRomanNumberal.put(secondDigitToRomanNumeral(i / 10) + firstDigitToRomanNumeral(i % 10), i);
        }
        return numberToRomanNumberal;
    }

    public String[] getSortedList(String[] kings) {
        Arrays.sort(kings, new KingComparator(numberToRomanNumeralMap()));
        return kings;
    }

    static public class KingComparator implements Comparator<String> {

        Map<String, Integer> numberToRomanNumeral;

        public KingComparator(Map<String, Integer> numberToRomanNumberal) {
            this.numberToRomanNumeral = numberToRomanNumberal;
        }

        @Override
        public int compare(String first, String second) {
            String[] firstSplit = first.split(" ");
            String[] secondSplit = second.split(" ");
            int nameComparison = firstSplit[0].compareTo(secondSplit[0]);
            if(nameComparison != 0) {
                return nameComparison;
            }
            return Integer.compare(numberToRomanNumeral.get(firstSplit[1]), numberToRomanNumeral.get(secondSplit[1]));
        }
    }

    public static void main(String[] args) {
        KingSort kingSort = new KingSort();
        String[] kings = { "Louis IX", "Louis VIII" };
        System.out.println(Arrays.toString(kingSort.getSortedList(kings)));
    }

}

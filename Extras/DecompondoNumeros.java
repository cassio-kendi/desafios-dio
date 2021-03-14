import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int maxDigit = 9;
        int fourDigitSum = 21;

        Map<Integer, List<String>> twoDigitSumsToTwoDigitNumbers = createMapWithTwoDigitSums(maxDigit, fourDigitSum);
        printAllCombinations(fourDigitSum, twoDigitSumsToTwoDigitNumbers);
    }

    private static Map<Integer, List<String>> createMapWithTwoDigitSums(int maxDigit, int fourDigitSum) {
        Map<Integer, List<String>> twoDigitSumsToTwoDigitNumbers = new HashMap<>();

        int maxTwoDigitSum = 2 * maxDigit;
        int minTwoDigitSum = fourDigitSum - 2 * maxDigit;
        for (int twoDigitSum = maxTwoDigitSum; twoDigitSum >= minTwoDigitSum; twoDigitSum--) {
            List<String> twoDigitsList = new ArrayList<>();
            int firstDigit = maxDigit <= twoDigitSum ? maxDigit : twoDigitSum;
            for (int j = firstDigit; j >= twoDigitSum - firstDigit; j--) {
                Integer twoDigitsInteger = 10 * j + twoDigitSum - j;
                twoDigitsList.add(twoDigitsInteger >= 10 ? String.valueOf(twoDigitsInteger)
                        : String.valueOf("0" + twoDigitsInteger));
            }
            twoDigitSumsToTwoDigitNumbers.put(twoDigitSum, twoDigitsList);
        }
        return twoDigitSumsToTwoDigitNumbers;
    }

    private static void printAllCombinations(int fourDigitSum, Map<Integer, List<String>> twoDigitSumsToTwoDigitNumbers) {
        for (Integer key : twoDigitSumsToTwoDigitNumbers.keySet()) {
            List<String> twoFirstDigitsList = twoDigitSumsToTwoDigitNumbers.get(key);
            List<String> twoLastDigitsList = twoDigitSumsToTwoDigitNumbers.get(fourDigitSum - key);

            for (String twoFirstDigits : twoFirstDigitsList) {
                if(!twoFirstDigits.startsWith("0")) {
                    for (String twoLastDigits : twoLastDigitsList) {
                        System.out.println(twoFirstDigits + twoLastDigits);
                    }
                }
            }
        }
    }
}

public class Main {

    private static final int MAX_DIGIT = 9;
    private static final int FOUR_DIGIT_SUM = 21;
    private static final int QUANTITY_DIGITS = 4;

    public static void main(String[] args) {
        printDigits("", QUANTITY_DIGITS, FOUR_DIGIT_SUM);
    }

    public static void printDigits(String prefix, int digitsLeft, int sum) {
        if (digitsLeft == 1) {
            System.out.println(prefix + String.valueOf(sum));
            return;
        }

        int maxLimit = MAX_DIGIT > sum ? sum : MAX_DIGIT;
        int minLimit = sum - (digitsLeft - 1) * MAX_DIGIT;
        for (int j = maxLimit; j >= minLimit && (j > 0 || (j == 0 && digitsLeft != QUANTITY_DIGITS)); j--) {
            printDigits(prefix + String.valueOf(j), digitsLeft - 1, sum - j);
        }
    }
}

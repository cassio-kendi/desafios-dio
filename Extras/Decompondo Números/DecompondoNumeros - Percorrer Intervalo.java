public class Main {
    public static void main(String[] args) {

        int maxDigit = 9;
        int fourDigitSum = 21;
        int maxNumber = maxDigit * 1000 + maxDigit * 100 + maxDigit * 10 + maxDigit;

        for (int i = 1000; i <= maxNumber; i++) {
            if (sumDigitsLessThanMaxDigit(i, maxDigit) == fourDigitSum)
                System.out.println(i);
        }
    }

    public static Integer sumDigitsLessThanMaxDigit(int n, int maxDigit) {
        Integer sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit > maxDigit)
                return -1;
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

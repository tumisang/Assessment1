package common.factor;

public class PrimeNumberChecker {

    private PrimeNumberChecker() {

    }

    public static boolean checkPrimeNumber(int number) {

        boolean isPrime = true;

        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }
}

package common.factor;

public class CommonDenominatorValidator {

    private static int commonDenominator = 1;

    private CommonDenominatorValidator() {

    }

    private static boolean isCommonDenominatorInIntegerArray(int commonDenominator, int[] intArray) {
        boolean isCommonDenominator = true;

        for (int number : intArray) {
            if (number % commonDenominator != 0) {
                isCommonDenominator = false;
            }
        }

        return isCommonDenominator;
    }

    public static int highestCommonFactor(int[] numbers) {

        // check if there is a prime number in the array
        boolean primeExists = false;
        for (int number : numbers) {
            primeExists = PrimeNumberChecker.checkPrimeNumber(number);
            // if there is a prime number then the common denominator of the integers in the array is 1
            if (primeExists) {
                break;
            }
        }

        if (!primeExists) {
            //sort the array
            IntegerArrayController integerArrayController = new IntegerArrayController(new IntegerArrayServiceImpl());
            int[] intArray = integerArrayController.getSortedIntArray(numbers);

            // check if the first integer in the array is an even number
            boolean isEvenNumber = EvenNumberChecker.isAnEvenNumberInteger(intArray[0]);

            /*
             if first number in array is an even number,
             get its highest common denominator and check with other proceeding numbers if this number can fold them without leaving a remainder
             */
            if (isEvenNumber) {
                commonDenominator = intArray[0];
                boolean isCommonDenominator = false;
                while (!isCommonDenominator && commonDenominator > 1) {
                    isCommonDenominator = isCommonDenominatorInIntegerArray(commonDenominator, intArray);
                    if (!isCommonDenominator) {
                        commonDenominator--;
                    }
                }
            }
        }

        return commonDenominator;
    }

}

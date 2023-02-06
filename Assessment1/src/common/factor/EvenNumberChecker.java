package common.factor;

public class EvenNumberChecker {

    private EvenNumberChecker() {

    }

    public static boolean isAnEvenNumberInteger(int number) {
        return number % 2 == 0 ? true : false;
    }


}

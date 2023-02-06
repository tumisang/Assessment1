package common.factor;

import java.util.List;

public interface ArrayService<T> {
    List<T> changeArrayToList(int[] intArray);
    List<T> sortArrayList(List<Integer> integerArrayList);
    int[] changeListToArray(List<T> arraylist);

}

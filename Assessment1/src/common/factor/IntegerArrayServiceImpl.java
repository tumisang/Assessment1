package common.factor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntegerArrayServiceImpl implements ArrayService<Integer> {

    private List<Integer> integerList = new ArrayList<Integer>();

    @Override
    public List<Integer> changeArrayToList(int[] intArray) {
        //clear array list if not empty
        if (!integerList.isEmpty()) {
            integerList.clear();
        }

        //transfer the int array data into array list
        for (int number : intArray) {
            integerList.add(number);
        }

        return integerList;
    }

    @Override
    public List<Integer> sortArrayList(List<Integer> integerArrayList) {
        // sort the list
//        integerArrayList.sort(new IntegerComparator());
        integerArrayList.sort(Comparator.naturalOrder());
        return integerArrayList;
    }

    @Override
    public int[] changeListToArray(List<Integer> arraylist) {
        int[] intArray = new int[arraylist.size()];
        for (int index = 0; index < arraylist.size(); index++) {
            intArray[index] = arraylist.get(index);
        }
        return intArray;
    }

}

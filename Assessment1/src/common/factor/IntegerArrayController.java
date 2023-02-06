package common.factor;

public class IntegerArrayController {

    private ArrayService arrayService;

    public IntegerArrayController(ArrayService arrayService){
        this.arrayService = arrayService;
    }
    public int[] getSortedIntArray(int[] intArray){
        return arrayService
                .changeListToArray(arrayService
                        .sortArrayList(arrayService
                                .changeArrayToList(intArray)
                        )
                );
    }

}

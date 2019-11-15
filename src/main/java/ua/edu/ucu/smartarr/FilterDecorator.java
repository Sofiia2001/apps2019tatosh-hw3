package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] arrayToReturn;
    private String operationName;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        operationName = smartArray.operationDescription();
        predicate = pr;
    }

    @Override
    public Object[] toArray() {
        operationName = "Filtering an array";
        Object[] array = smartArray.toArray();
        arrayToReturn = new Object[smartArray.size()];
        int insertionIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.test(array[i])) {
                arrayToReturn[insertionIndex] = array[i];
                insertionIndex++;
            } else {
//                lessening an array length to avoid nulls in the array
                arrayToReturn = Arrays.copyOf(arrayToReturn,
                        arrayToReturn.length - 1);
            }
        }
        return arrayToReturn;
    }

    @Override
    public String operationDescription() {
        return operationName;
    }

    @Override
    public int size() {
        operationName = "size";
        return arrayToReturn.length;
    }
}

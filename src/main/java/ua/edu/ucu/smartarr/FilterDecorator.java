package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.function.Predicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] ArrayToReturn;
    private String operationName;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        operationName = smartArray.operationDescription();
        predicate = pr;
    }

    @Override
    public Object[] toArray() {
        operationName = "toArray";
        Object[] array = smartArray.toArray();
        ArrayToReturn = new Object[smartArray.size()];
        int insertionIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.test(array[i])) {
                ArrayToReturn[insertionIndex] = array[i];
                insertionIndex++;
            } else {
//                lessening an array length to avoid nulls in the array
                ArrayToReturn = Arrays.copyOf(ArrayToReturn,
                        ArrayToReturn.length - 1);
            }
        }
        return ArrayToReturn;
    }

    @Override
    public String operationDescription() {
        return operationName;
    }

    @Override
    public int size() {
        operationName = "size";
        return ArrayToReturn.length;
    }
}

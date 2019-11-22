package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;
    private String operationName;

    public BaseArray(Object[] arr) {
        array = Arrays.copyOf(arr, arr.length);
        operationName = "toArray";
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return operationName;
    }

    @Override
    public int size() {
        return array.length;
    }
}

package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;
    private String operationName;

    public BaseArray(Object[] arr) {
        array = arr;
    }

    @Override
    public Object[] toArray() {
        operationName = "toArray";
        return array;
    }

    @Override
    public String operationDescription() {
        return operationName;
    }

    @Override
    public int size() {
        operationName = "size";
        return array.length;
    }
}

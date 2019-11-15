package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;
    private String operationName;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        operationName = smartArray.operationDescription();
        comparator = cmp;
    }

    @Override
    public Object[] toArray() {
        operationName = "Sorting elements";
        Object[] array = smartArray.toArray();
        Arrays.sort(array, comparator);
        return array;
    }

    @Override
    public String operationDescription() {
        return operationName;
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

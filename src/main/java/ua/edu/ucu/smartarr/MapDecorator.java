package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;
    private String operationName;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        operationName = smartArray.operationDescription();
        function = func;
    }

    @Override
    public Object[] toArray() {
        operationName = "Mapping elements to another object";
        Object[] array = smartArray.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = function.apply(array[i]);
        }
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

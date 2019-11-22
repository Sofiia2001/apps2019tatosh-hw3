package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] arrayToReturn;
    private String operationName;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        operationName = "Removing duplicates";
        arrayToReturn = smartArray.toArray();
    }

    @Override
    public Object[] toArray() {
        Object[] array = arrayToReturn;
        arrayToReturn = new Object[smartArray.size()];
        int insertIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j = 0; j <= insertIndex; j++) {
                if (!array[i].equals(arrayToReturn[j])) {
                    counter++;
                }
//                }
            }
            if (counter == insertIndex + 1) {
                arrayToReturn[insertIndex] = array[i];
                insertIndex++;
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
        return arrayToReturn.length;
    }
}

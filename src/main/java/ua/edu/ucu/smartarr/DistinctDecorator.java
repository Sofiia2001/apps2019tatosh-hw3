package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] ArrayToReturn;
    private String operationName;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        operationName = smartArray.operationDescription();
    }

    @Override
    public Object[] toArray() {
        operationName = "toArray";
        Object[] array = smartArray.toArray();
        ArrayToReturn = new Object[smartArray.size()];
        int insertIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j = 0; j <= insertIndex; j++) {
                if (!array[i].equals(ArrayToReturn[j])) {
                    counter++;
                }
//                }
            }
            if (counter == insertIndex + 1) {
                ArrayToReturn[insertIndex] = array[i];
                insertIndex++;
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

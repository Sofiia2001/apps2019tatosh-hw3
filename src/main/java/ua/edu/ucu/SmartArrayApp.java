package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

        MyFunction func = t -> 2 * ((Integer) t);

        SmartArray sa = new BaseArray(integers);

        sa = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(sa, pr),
                        cmp),
                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pr = t -> ((Student) t).getYear() == 2;

        MyPredicate prAv = t -> ((Student) t).getGPA() >= 4;

        MyComparator cmp = (o1, o2) ->
                ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());

        SmartArray sa = new BaseArray(students);

        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new FilterDecorator(sa, prAv);
        sa = new SortDecorator(sa, cmp);

        Object[] result = sa.toArray();
        String[] resultA = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            resultA[i] = ((Student) result[i]).getSurname() + " " + ((Student) result[i]).getName();
        }
        return resultA;
    }
}

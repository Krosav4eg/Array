package array.project;

import java.util.Arrays;

/**
 * Basic Array providing searching minimal duplicate of element.
 *
 * @author Sergey
 */
public class BasicArray {

    /**
     *
     * @param array
     * @return
     */
    public static int[] toReplaceMinimumAndMaximumElements(int[] array) {
        validateArray(array);

        int min = array[0];
        int max = array[0];
        int idMin = 0;
        int idMax = 0;

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                idMin = i;
            }
            if (max < array[i]) {
                max = array[i];
                idMax = i;
            }
        }
        array[idMin] = max;
        array[idMax] = min;

        return array;
    }

    /**
     * Searching min element
     *
     * @param array
     * @return
     */
    public static int[] findMinElement(int[] array) {
        validateArray(array);

        Arrays.sort(array);
        int minElem = array[0];
        int duplicate = 0;

        for (int item : array) {
            if (item == minElem) {
                duplicate++;
            }
        }
        int[] resultArray = new int[duplicate];
        Arrays.fill(resultArray, minElem);

        return resultArray;
    }

    /**
     * @param array
     */
    public static void toPrintArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * @param array
     * @return
     */
    public static double calculateArithmeticAverage(int[] array) {
        validateArray(array);

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;

    }

    /**
     *
     * @return
     */
    public static int[] createFirstOddNumbers() {
        int[] array = new int[10];
        int x = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = x;
            x = x + 2;
        }
        return array;
    }

    /**
     * validate array on correct values
     *
     * @param array incoming array
     * @throws IllegalArgumentException if array is null
     * @throws IllegalArgumentException if array is empty
     */
    private static void validateArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (array.length < 1) {
            throw new IllegalArgumentException("Array is empty");
        }
    }
}

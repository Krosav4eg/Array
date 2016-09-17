package array.project;

/**
 * @author Sergey
 */

public class MainApplication {

    public static void main(String[] args) {
        //task 1
        System.out.println("task_1");
        int[] oddArray = BasicArray.createFirstOddNumbers();
        BasicArray.toPrintArray(oddArray);

        //task 2

        System.out.println("task_2");
        int[] arrayExample1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        int[] minElement = BasicArray.findMinElement(arrayExample1);
        BasicArray.toPrintArray(minElement);

        //task3

        System.out.println("task_3");
        int[] arrayExample2 = {1, 12, 3, 48, 51, 6, 78, 8, 9, -8};
        int[] replaceElementsArray = BasicArray.toReplaceMinimumAndMaximumElements(arrayExample2);
        BasicArray.toPrintArray(replaceElementsArray);
        //task4
        System.out.println("task_4");
        int [] arrayExample3 = {1, 182, 3, 48, 5, 68, 78, 87, 9, -8};
        double arithmeticAverageArray= BasicArray.calculateArithmeticAverage(arrayExample3);
        System.out.println(arithmeticAverageArray);

    }
}

package array.project;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

public class BasicArrayTest {

    @Test
    public void findMinElementTest() {
        assertArrayFind(new int[]{1, -1, 3, 4}, new int[]{-1});
        assertArrayFind(new int[]{1, 1, 3, 4}, new int[]{1, 1});
        assertArrayFind(new int[]{1, 1, 1, 1, 1, 1, 3, 4}, new int[]{1, 1, 1, 1, 1, 1});
        assertArrayFind(new int[]{-1, -1, -1, 1, 1, 1, 3, 4}, new int[]{-1, -1, -1});

        assertArrayFind(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE});
        assertArrayFind(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});

        assertArrayFind(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE});
        assertArrayFind(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});

        assertArrayFind(new int[]{1, -2, 3, 4}, new int[]{-2});
        assertArrayFind(new int[]{1, 2, 3, 0}, new int[]{0});
        assertArrayFind(new int[]{1, 2, 3, -4}, new int[]{-4});

        //validate dimension
        int size = Integer.MAX_VALUE / 320;
        int[] a1 = new int[size];
        a1[0] = -1;
        assertArrayFind(a1, new int[]{-1});

        a1[1] = -66666;
        a1[2] = -66666;
        assertArrayFind(a1, new int[]{-66666, -66666});

        // test throws method exception
        assertIncorrectArrayFind(new int[]{});
        assertIncorrectArrayFind(null);
    }

    @Test
    public void toReplaceMinimumAndMaximumElementsTest() {
        assertArrayReplace(new int[]{-1, 5}, new int[]{5, -1});
        assertArrayReplace(new int[]{-1}, new int[]{-1});
        assertArrayReplace(new int[]{0}, new int[]{0});

        assertArrayReplace(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE});
        assertArrayReplace(new int[]{Integer.MIN_VALUE}, new int[]{Integer.MIN_VALUE});
        assertArrayReplace(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});


//       assertArrayReplace(new int[]{-1,-1,5}, new int[]{5,5,-1}); todo

        assertIncorrectArrayReplace(null);
        assertIncorrectArrayReplace(new int[]{});

    }

    @Test
    public void createFirstOddNumbers() {
        //When
        int[] array = BasicArray.createFirstOddNumbers();

        //Then
        assertTrue(Arrays.equals(array, new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}));
    }

    @Test
    public void calculateArithmeticAverageTest() {

        assertArrayAverage(new int[]{1}, 1.0);
        assertArrayAverage(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1.0);

        assertArrayAverage(new int[]{1, -1}, 0.0);
        assertArrayAverage(new int[]{1, -1, 0}, 0.0);

        assertArrayAverage(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, (double) Integer.MAX_VALUE);
        assertArrayAverage(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}, (double) Integer.MIN_VALUE);
        assertArrayAverage(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, -0.5);

        //exception
        assertIncorrectArrayAverage(null);
        assertIncorrectArrayAverage(new int[]{});
    }


    private void assertArrayAverage(int[] actualArray, double expectNum) {
        double element = BasicArray.calculateArithmeticAverage(actualArray);
        assertEquals(element, expectNum);
    }


    private void assertArrayReplace(int[] actualArray, int[] expectArray) {
        int[] elements = BasicArray.toReplaceMinimumAndMaximumElements(actualArray);
        assertTrue(Arrays.equals(elements, expectArray));
    }

    /**
     * @param actualArray
     * @param expectArray
     */
    private void assertArrayFind(int[] actualArray, int[] expectArray) {
        int[] minElement = BasicArray.findMinElement(actualArray);
        assertTrue(Arrays.equals(minElement, expectArray));
    }

    /**
     * Expect fail in actualArray
     *
     * @param actualArray
     */
    private void assertIncorrectArrayFind(int[] actualArray) {
        try {
            BasicArray.findMinElement(actualArray);
            fail("Exception  wasn't throw!");
        } catch (IllegalArgumentException ignore) {
        }
    }

    //
    private void assertIncorrectArrayReplace(int[] actualArray) {
        try {
            BasicArray.toReplaceMinimumAndMaximumElements(actualArray);
            fail("Exception  wasn't throw!");
        } catch (IllegalArgumentException ignore) {
        }
    }

    //
    private void assertIncorrectArrayAverage(int[] actualArray) {
        try {
            BasicArray.calculateArithmeticAverage(actualArray);
            fail("Exception  wasn't throw!");
        } catch (IllegalArgumentException ignore) {
        }
    }
}

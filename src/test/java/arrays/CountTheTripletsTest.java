package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountTheTripletsTest {
    private CountTheTriplets countTheTriplets;

    @Before
    public void before() {
        countTheTriplets = new CountTheTriplets();
    }

    @Test
    public void firstTestCase() {
        int[] arr = {1, 5, 3, 2};
        int n = 4;
        assertEquals(2, countTheTriplets.countTriplet(arr, n));
    }

    @Test
    public void secondTestCase() {
        int[] arr = {2, 3, 4};
        int n = 3;
        assertEquals(0, countTheTriplets.countTriplet(arr, n));
    }

    @Test
    public void stackOverflowTest() {
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        assertEquals(249001, countTheTriplets.countTriplet(arr, n));
    }
}

package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KadaneTest {
    private Kadane kadane;

    @Before
    public void before() {
        kadane = new Kadane();
    }

    @Test
    public void firstTestCase() throws IllegalAccessException {
        int n = 5;
        int[] arr = {1, 2, 3, -2, 5};
        assertEquals(9, kadane.maxSubarraySum(arr, n));
    }

    @Test
    public void secondTestCase() throws IllegalAccessException {
        int n = 4;
        int[] arr = {-1, -2, -3, -4};
        assertEquals(-1, kadane.maxSubarraySum(arr, n));
    }

    @Test
    public void stackOverflowTest() throws IllegalAccessException {
        int n = 10_000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        assertEquals(49995000, kadane.maxSubarraySum(arr, n));
    }
}

package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RearrangeArrayAlternativelyTest {
    private RearrangeArrayAlternatively rearrangeArrayAlternatively;

    @Before
    public void before() {
        rearrangeArrayAlternatively = new RearrangeArrayAlternatively();
    }

    @Test
    public void firstTestCase() {
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrangeArrayAlternatively.rearrange(arr, n);

        assertArrayEquals(arr, new int[]{6, 1, 5, 2, 4, 3});
    }

    @Test
    public void secondTestCase() {
        int n = 11;
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        rearrangeArrayAlternatively.rearrange(arr, n);

        assertArrayEquals(arr, new int[]{110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60});
    }

    @Test
    public void stackOverflowTest() {
        int n = 10_000_000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        rearrangeArrayAlternatively.rearrange(arr, n);

        assertEquals(5000000, arr[n - 1]);
    }
}

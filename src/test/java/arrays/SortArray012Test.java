package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortArray012Test {
    private SortArray012 sortArray012;

    @Before
    public void before() {
        sortArray012 = new SortArray012();
    }

    @Test
    public void firstTestCase() {
        int n = 5;
        int[] arr = {0, 2, 1, 2, 0};
        int[] expected = {0, 0, 1, 2, 2};

        sortArray012.sort012(arr, n);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void secondTestCase() {
        int n = 3;
        int[] arr = {0, 1, 0};
        int[] expected = {0, 0, 1};

        sortArray012.sort012(arr, n);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void stackOverflowTest() {
        int n = 1_000_000;
        int[] arr = new int[n];
        IntStream.range(0, n / 3).forEach(e -> arr[e] = 2);
        IntStream.range(n / 3, 2 * n / 3).forEach(e -> arr[e] = 1);
        IntStream.range(2 * n / 3, n).forEach(e -> arr[e] = 0);

        sortArray012.sort012(arr, n);
        assertEquals(0, arr[0]);
        assertEquals(2, arr[n - 1]);
    }
}

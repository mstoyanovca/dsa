package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CountInversionsTest {
    private CountInversions countInversions;

    @Before
    public void before() {
        countInversions = new CountInversions();
    }

    @Test
    public void firstTestCase() {
        int n = 5;
        long[] arr = {2, 4, 1, 3, 5};

        assertEquals(3, countInversions.inversionCount(arr, n));
    }

    @Test
    public void secondTestCase() {
        int n = 5;
        long[] arr = {2, 3, 4, 5, 6};

        assertEquals(0, countInversions.inversionCount(arr, n));
    }

    @Test
    public void thirdTestCase() {
        int n = 3;
        long[] arr = {10, 10, 10};

        assertEquals(0, countInversions.inversionCount(arr, n));
    }

    @Test
    public void stackOverflowTest() {
        int n = 500_000;
        long[] arr = new long[n];
        IntStream.range(0, n).forEach(e -> arr[e] = n - e);

        assertEquals(124999750000L, countInversions.inversionCount(arr, n));
    }
}

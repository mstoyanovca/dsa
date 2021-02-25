package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfPairsTest {
    private NumberOfPairs numberOfPairs;

    @Before
    public void before() {
        numberOfPairs = new NumberOfPairs();
    }

    @Test
    public void firstTestCase() {
        int m = 3;
        int n = 2;
        int[] x = {2, 1, 6};
        int[] y = {1, 5};

        assertEquals(3, numberOfPairs.countPairs(x, y, m, n));
    }

    @Test
    public void secondTestCase() {
        int m = 4;
        int n = 3;
        int[] x = {2, 3, 4, 5};
        int[] y = {1, 2, 3};

        assertEquals(5, numberOfPairs.countPairs(x, y, m, n));
    }

    @Test
    public void stackOverflowTest() {
        int m = 100_000;
        int n = 100_000;

        int[] x = new int[m];
        for (int i = 1; i <= m; i++) x[i - 1] = Math.min(i, 1_000);

        int[] y = new int[n];
        for (int i = 1; i <= n; i++) y[i - 1] = Math.min(i, 1_000);

        assertEquals(99400499, numberOfPairs.countPairs(x, y, m, n));
    }
}

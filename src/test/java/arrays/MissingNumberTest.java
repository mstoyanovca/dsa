package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNumberTest {
    private MissingNumber missingNumber;

    @Before
    public void before() {
        missingNumber = new MissingNumber();
    }

    @Test
    public void firstTestCase() {
        int n = 5;
        int[] arr = {1, 2, 3, 5};
        assertEquals(4, missingNumber.missingNo(arr, n));
    }

    @Test
    public void secondTestCase() {
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        assertEquals(9, missingNumber.missingNo(arr, n));
    }

    @Test
    public void stackOverflowTest() {
        int n = 1_000_000;
        int[] arr = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = i;
        }
        assertEquals(1_000_000, missingNumber.missingNo(arr, n));
    }
}

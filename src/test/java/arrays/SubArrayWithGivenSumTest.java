package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SubArrayWithGivenSumTest {
    private SubArrayWithGivenSum subArrayWithGivenSum;

    @Before
    public void before() {
        subArrayWithGivenSum = new SubArrayWithGivenSum();
    }

    @Test
    public void firstTestCase() {
        int n = 5;
        int s = 12;
        int[] arr = {1, 2, 3, 7, 5};
        assertEquals(new ArrayList<>(Arrays.asList(2, 4)), subArrayWithGivenSum.subarraySum(arr, n, s));
    }

    @Test
    public void secondTestCase() {
        int n = 10;
        int s = 15;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(new ArrayList<>(Arrays.asList(1, 5)), subArrayWithGivenSum.subarraySum(arr, n, s));
    }

    @Test
    public void errorTest() {
        int n = 3;
        int s = 20;
        int[] arr = {1, 2, 3};
        assertEquals(new ArrayList<>(Collections.singletonList(-1)), subArrayWithGivenSum.subarraySum(arr, n, s));
    }

    @Test
    public void stackOverflowTest() {
        int n = 100_000;
        int s = 111_111;
        int[] arr = new int[n];
        for (int x = 0; x < n; x++) {
            arr[x] = x;
        }

        assertEquals(new ArrayList<>(Arrays.asList(11, 472)), subArrayWithGivenSum.subarraySum(arr, n, s));
    }
}

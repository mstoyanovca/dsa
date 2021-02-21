package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeWithoutExtraSpaceTest {
    public MergeWithoutExtraSpace mergeWithoutExtraSpace;

    @Before
    public void before() {
        mergeWithoutExtraSpace = new MergeWithoutExtraSpace();
    }

    @Test
    public void firstTestCase() {
        int n = 4;
        int m = 5;
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        mergeWithoutExtraSpace.merge(arr1, arr2, n, m);

        assertEquals(0, arr1[0]);
        assertEquals(5, arr2[0]);
    }

    @Test
    public void secondTestCase() {
        int n = 2;
        int m = 3;
        int[] arr1 = {10, 12};
        int[] arr2 = {5, 18, 20};

        mergeWithoutExtraSpace.merge(arr1, arr2, n, m);

        assertEquals(5, arr1[0]);
        assertEquals(12, arr2[0]);
    }

    @Test
    public void stackOverflowTest() {
        int n = 50_000;
        int m = 50_000;
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = 2 * i;
        }
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = i % 2 == 0 ? i + 50_001 : i;
        }

        mergeWithoutExtraSpace.merge(arr1, arr2, n, m);

        assertEquals(0, arr1[0]);
        assertEquals(62512, arr2[0]);
    }
}

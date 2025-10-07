package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    public void testSortSmallArray() {
        int[] arr = {4, 10, 3, 5, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        sorter.sort(arr);

        assertArrayEquals(new int[]{1, 3, 4, 5, 10}, arr,
                "HeapSort should correctly sort a small array");
    }

    @Test
    public void testSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        sorter.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr,
                "HeapSort should leave already sorted arrays unchanged");
    }

    @Test
    public void testSortReverseOrder() {
        int[] arr = {9, 7, 5, 3, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        sorter.sort(arr);

        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr,
                "HeapSort should correctly sort a reverse-ordered array");
    }

    @Test
    public void testSortWithDuplicates() {
        int[] arr = {4, 10, 4, 5, 10, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        sorter.sort(arr);

        assertArrayEquals(new int[]{1, 4, 4, 5, 10, 10}, arr,
                "HeapSort should correctly handle duplicate elements");
    }
}

package cli;

import algorithms.MaxHeap;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random();

        for (int n : sizes) {
            PerformanceTracker tracker = new PerformanceTracker();
            MaxHeap heap = new MaxHeap(n, tracker);

            tracker.start();
            for (int i = 0; i < n; i++) {
                heap.insert(random.nextInt());
            }
            tracker.stop();

            System.out.printf("n=%d | time=%.3f ms | comparisons=%d | swaps=%d%n",
                    n, tracker.getElapsedTimeMs(), tracker.comparisons, tracker.swaps);
        }
    }
}

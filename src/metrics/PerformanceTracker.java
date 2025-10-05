package metrics;

public class PerformanceTracker {
    public long comparisons = 0;
    public long swaps = 0;
    private long startTime;
    private long endTime;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }
    public double getElapsedTimeMs() { return (endTime - startTime) / 1e6; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        startTime = 0;
        endTime = 0;
    }
}


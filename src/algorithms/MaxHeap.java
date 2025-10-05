package algorithms;

import metrics.PerformanceTracker;

public class MaxHeap {
    private int[] heap;
    private int size;
    private final int capacity;
    private final PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
        this.tracker = tracker;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        tracker.swaps++;
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = value;
        size++;
        increaseKey(size - 1, value);
    }

    public void increaseKey(int i, int newValue) {
        if (newValue < heap[i]) throw new IllegalArgumentException("New value is smaller");
        heap[i] = newValue;
        while (i > 0) {
            tracker.comparisons++;
            if (heap[parent(i)] < heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            } else break;
        }
    }

    public int extractMax() {
        if (size <= 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return max;
    }

    private void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size) {
            tracker.comparisons++;
            if (heap[l] > heap[largest]) largest = l;
        }
        if (r < size) {
            tracker.comparisons++;
            if (heap[r] > heap[largest]) largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}

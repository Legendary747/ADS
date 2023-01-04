package weblab;

import java.util.*;

class SolutionPQ {

    private final List<Integer> heap;

    public SolutionPQ() {
        heap = new ArrayList<>();
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param i array index of one element to swap
     * @param j array index of the other element to swap
     */
    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    /**
     * Restores the heap order property top-down in a heap represented as an ArrayList.
     * When the heap property is invalid at node with index i,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param i index of the node of the heap to start downHeap from
     */
    private void downHeap(int i) {
        // indices of left and right children
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // WRONG DOWNHEAP< THIS IS MAX QUEUE NOT MIN QUEUE

        // find node with smallest key
        int smallest = i;
        if (left < heap.size() && heap.get(left) > heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) > heap.get(smallest)) smallest = right;
        
        if (smallest == i)
            return; // heap order satisfied

        swap(i, smallest);
        downHeap(smallest);
    }

    /**
     * Restores the heap order property bottom-up in a heap represented as an ArrayList.
     * The method compares the node to its parent, swaps if necessary,
     * and performs this same operation again and again while traversing up the heap
     * until the property is restored.
     *
     * @param i index of the node
     */
    public void upHeap(int i) {
        int pi = (i-1)/2;
        if (pi < 0) return;
        if (heap.get(pi) >= heap.get(i)) return;
        else {
            swap(pi, i);
            upHeap(pi);
        }
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param elem the element to add
     */
    public void add(int elem) {
        heap.add(elem);
        upHeap(heap.size() - 1);
    }

    /**
     * Retrieves and removes the first element of this priority queue.
     *
     * @return the first element of the queue
     */
    public int poll() {
        // TO DO
        int max = heap.get(0);
        swap(heap.size() - 1, 0);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return max;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the current number of elements in the heap
     */
    public int size() {
        return this.heap.size();
    }
}

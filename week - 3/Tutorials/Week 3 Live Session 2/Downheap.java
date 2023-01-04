package weblab;

class MaxHeap extends LibraryMaxHeap {

    public MaxHeap(int[] arr) {
        super(arr);
    }

    /**
     * Restores the heap property in a heap represented as an array.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param root
     *     Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range
     *     Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    @Override
    public void downHeap(int root, int range) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (root * 2 + 1 <= range) left = heap[root * 2 + 1];
        if (root * 2 + 2 <= range) right = heap[root * 2 + 2];
        if (left == Integer.MIN_VALUE && right == Integer.MIN_VALUE) return;
        int toSwap = left > right ? root * 2 + 1 : root * 2 + 2;
        if (heap[toSwap] > heap[root]) swap(heap, toSwap, root);
        downHeap(toSwap, range);
    }
}

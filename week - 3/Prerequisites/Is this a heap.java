package weblab;

class Solution {

    /**
     * Checks whether the given array is a max-heap.
     *
     * @param arr integer array to be checked (root at index 0)
     * @param n the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     */
    public static boolean isHeap(int[] arr, int n) {
        if (arr == null) return false;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int dadIndex = getParent(arr, i);
            while (dadIndex != -1) {
                if (cur > arr[dadIndex]) return false;
                cur = arr[dadIndex];
                dadIndex = getParent(arr, dadIndex);
            }
        }
        return true;
    }

    /**
     * Gives the index of the parent of the node corresponding to the given index.
     *
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i index of node whose parent we're looking for (make no assumptions about its validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have a parent
     */
    public static int getParent(int[] arr, int i) {
        if (arr == null || arr.length <= i) return -1;
        if (i % 2 == 0 && (i - 2) / 2 >= 0) return (i - 2) / 2;
        else if (i % 2 == 1 && (i - 1) / 2 >= 0) return (i - 1) / 2;
        return -1;
    }
}

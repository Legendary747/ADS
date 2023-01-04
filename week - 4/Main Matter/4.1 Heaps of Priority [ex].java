package weblab;

import java.util.*;

class Solution {

    /**
     * Takes a list and returns a new list sorted in descending order.
     * This is done by using the priority queue `queue`.
     *
     * Return null if list is null.
     *
     * @param list
     *     the array that needs to be sorted.
     */
    public static List<Integer> pqSort(List<Integer> list) {
        if (list == null) return null;
        LibraryPQ queue = new SolutionPQ();
        for (Integer i : list) queue.insert(i);
        ArrayList<Integer> ans = new ArrayList();

        for (int j = 0; j < list.size(); j++) {
            ans.add(queue.removeMax());
        }
        return ans;
    }
}

class SolutionPQ extends LibraryPQ {

    /**
     * Restores the heap property in a heap represented as an arraylist.
     * The method compares the node to its parent and swaps if necessary.
     *
     * @param i
     *     index of the node
     */
    @Override
    public void upHeap(int i) {
        int pi = (i - 1)/2;
        if (pi < 0) return;
        if (getInHeap(pi) < getInHeap(i)) {
            swap(pi, i);
            upHeap(pi);
        }
    }
}

package weblab;
import java.util.*;

class Solution {

    /**
     * @param elements
     *     - array of integers to be sorted.
     */
    public static void insertionSort(int[] elements) {
        if (elements == null) return;
        for (int i = 0; i < elements.length; i++) {
            int cur = elements[i];
            int j = i - 1;
            while (j >= 0) {
                if (elements[j] > cur) {
                    elements[j + 1] = elements[j];
                    elements[j] = cur;
                    j--;
                } else {
                    j++;
                    elements[j] = cur;
                    break;
                }
            }
        }
    }
}

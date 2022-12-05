package weblab;
import java.util.*;

class Solution {

    /**
     * @param elements
     *     - array of integers to be sorted.
     */
    public static void insertionSort(int[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int min = elements[i];
            int tmp = i; // index
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < min) {
                    min = elements[j];
                    tmp = j;
                }
            }
            elements[tmp] = elements[i];
            elements[i] = min; 
        }
    }
}

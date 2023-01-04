package weblab;

import java.util.*;

public class Solution {

    /**
     * Sorts an array of integers in ascending order. This operation is not-in-place.
     *
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null) return null;
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
            
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i+mid];  
        }
        left = mergeSort(left);
        right = mergeSort(right);
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
        return arr;
        // TODO
    }
}

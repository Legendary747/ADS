package weblab;

import java.util.*;

class Solution {

    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     *
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return null;
        // Note the edge case here.
        // You have to be aware that the question 
        // requires a new Array as a copy.
        // returing the reference will be count as wrong.
        // By having a test arr1 == returned array {} -> assertionFail;
        if (arr1 == null) return Arrays.copyOf(arr2, arr2.length);
        if (arr2 == null) return Arrays.copyOf(arr1, arr1.length);
        int[] ans = new int[arr1.length + arr2.length];
        int l = 0;
        int r = 0;
        int index = 0;
        while (l < arr1.length && r < arr2.length) {
            if (arr1[l] < arr2[r]) ans[index++] = arr1[l++];
            else ans[index++] = arr2[r++];
        }
        while (l < arr1.length) ans[index++] = arr1[l++];
        while (r < arr2.length) ans[index++] = arr2[r++];
        return ans;
    }
}

package weblab;

public class Solution {

    /**
     * Sorts an array of integers in ascending order, this operation needs to be in-place.
     *
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static void bubbleSort(int[] arr) {
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp; 
                }
            }
        
        }
    }
}

package weblab;

class Solution {

    /**
     * Reverses the order of the elements of the given array.
     *
     * @param arr
     *     the array to reverse
     */
    public static void reverse(int[] arr) {
        // Edge Case
        if (arr == null || arr.length <= 1) return;
        // Normal
        int m = arr.length/2;
        for (int i = 0; i < m ; i++){
            int tmp = arr[i];
            System.out.println(tmp);
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
    }
}

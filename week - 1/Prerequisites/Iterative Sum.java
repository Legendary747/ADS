package weblab;

class Solution {

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n the index of the last item to consider
     */
    public static int sumElementsUpTo(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++){
            sum += arr[i];
        }
        return sum;
        // TODO
    }
}

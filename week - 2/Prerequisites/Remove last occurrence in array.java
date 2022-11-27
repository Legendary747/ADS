package weblab;
import java.util.Arrays;

class Solution {

    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x
     *     the entry to remove from the array
     * @param arr
     *     to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        if(arr == null) return arr;
        boolean contains = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                contains = true;
                break;
            }
        }
        int[] ans = null;
        if (!contains) return Arrays.copyOf(arr, arr.length);
        ans = new int[arr.length - 1];
        int index = ans.length - 1;
        boolean first = true;
        for (int i = arr.length - 1; i >= 0; i--){
            if (first && arr[i] == x) {
                first = false;
                continue;
            }
            ans[index--] = arr[i];
        }
        return ans;
    }
}

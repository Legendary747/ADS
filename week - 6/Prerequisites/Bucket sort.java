package weblab;

import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        if (array == null || array.length < 1) return new Queue[0];
        int vmin = Integer.MAX_VALUE;
        int vmax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < vmin) vmin = array[i];
            if (array[i] > vmax) vmax = array[i];
        }

        // System.out.println(vmin);
        // System.out.println(vmax);

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList();
        }

        for (int i = 0; i < array.length; i++) {
            buckets[array[i] - vmin].add(array[i]);
        }

        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        int size = 0;
        for (int i = 0; i < buckets.length; i++) {
            size += buckets[i].size();
        }
        int[] ans = new int[size];

        int k = 0;

        for (int i = 0; i < buckets.length; i++) {
            while (!buckets[i].isEmpty()) {
                ans[k++] = buckets[i].remove();
            }
        }

        return ans;
    }
}

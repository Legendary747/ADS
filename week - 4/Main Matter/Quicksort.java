package weblab;
import java.util.*;

class Solution {

    /**
     * @param elements
     *     Array of integers to be sorted.
     */
    public static void quickSort(int[] elements) {
        if (elements == null || elements.length <= 1) return;
        int pivot = elements[elements.length - 1];
        ArrayList<Integer> small = new ArrayList();
        ArrayList<Integer> same = new ArrayList();
        ArrayList<Integer> big = new ArrayList();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == pivot) same.add(elements[i]);
            else if (elements[i] < pivot) small.add(elements[i]);
            else big.add(elements[i]);
        }

        int[] smaller = new int[small.size()];
        int[] ssame = new int[same.size()];
        int[] bigger = new int[big.size()];

        for (int z = 0; z < small.size();z++) {
            smaller[z] = small.get(z);
        }
        for (int z = 0; z < same.size();z++) {
            ssame[z] = same.get(z);
        }
        for (int z = 0; z < big.size();z++) {
            bigger[z] = big.get(z);
        }

        quickSort(smaller);
        quickSort(bigger);

        int i = 0;
        int m = 0;
        int j = 0;
        int k = 0;

        int[] toReturn = new int[elements.length];

        while (i < smaller.length) {
            toReturn[k++] = smaller[i++];
        }

        while (m < ssame.length) {
            toReturn[k++] = ssame[m++];
        }

        while (j < bigger.length) {
            toReturn[k++] = bigger[j++];
        }

        for (int z = 0; z < toReturn.length; z++) {
            elements[z] = toReturn[z];
        }


    }
}

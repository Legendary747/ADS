package weblab;

import java.util.*;

class Solution {

    /**
     * Reverses the queue itself. NB: This method should be recursive.
     */
    public static void reverse(LibraryQueue queue) {
        if (queue == null) return;
        if (queue.isEmpty()) {
            return;
        }
        int cur = queue.dequeue();
        reverse(queue);
        queue.enqueue(cur);
    }

}

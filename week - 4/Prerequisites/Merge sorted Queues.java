package weblab;
import java.util.*;

class Solution {

    /**
     * @param queue1 first sorted Queue to be merged
     * @param queue2 second sorted Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     */
    public static LibraryQueue<Integer> merge(
            LibraryQueue<Integer> queue1, LibraryQueue<Integer> queue2) {
        if (queue1 == null && queue2 == null) return null;

        ArrayList<Integer> l1 = new ArrayList();
        ArrayList<Integer> l2 = new ArrayList();

        while (queue1 != null && !queue1.isEmpty()) l1.add(queue1.dequeue());
        while (queue2 != null && !queue2.isEmpty()) l2.add(queue2.dequeue());
        if (queue1 == queue2) {
            l2 = new ArrayList(l1);
        }

        LibraryQueue<Integer> q = new LibraryQueue();
//      Restore the queue
        if (queue1 == queue2) {
            for (int i = 0; i < l1.size(); i++) {
                queue1.enqueue(l1.get(i));
            }
        } else {
            if (queue1 != null) {
                for (int i = 0; i < l1.size(); i++) {
                    queue1.enqueue(l1.get(i));
                }
            }
            if (queue2 != null) {
                for (int i = 0; i < l2.size(); i++) {
                    queue2.enqueue(l2.get(i));
                }
            }
        }
        

//      Some checks
        if (queue1 == null) {
            for (int i = 0; i < l2.size(); i++) q.enqueue(l2.get(i));
            return q;
        }

        if (queue2 == null) {
            for (int i = 0; i < l1.size(); i++) q.enqueue(l1.get(i));
            return q;
        }

        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                q.enqueue(l1.get(i++));
            } else {
                q.enqueue(l2.get(j++));
            }
        }
        while (i < l1.size()) q.enqueue(l1.get(i++));
        while (j < l2.size()) q.enqueue(l2.get(j++));
        return q;

    }
}

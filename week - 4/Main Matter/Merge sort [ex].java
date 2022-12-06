package weblab;
import java.util.*;

class Solution {

    public static LibraryQueue<Lawyer> sortingSomeLawyer(LibraryQueue<Lawyer> queue) {
        // TODO
        if (queue == null || queue.size() <= 1) return queue;
        LibraryQueue<Lawyer> copy = new LibraryQueue();
        LibraryQueue<Lawyer> left = new LibraryQueue();
        LibraryQueue<Lawyer> right = new LibraryQueue();

        int mid = queue.size() / 2;
        int l = mid;
        int r = mid;
        if (queue.size() % 2 == 1) l += 1;

        int i = 0;
        int j = 0;
        while (i++ < l) {
            Lawyer cur = queue.dequeue();
            copy.enqueue(cur);
            left.enqueue(cur);
        }

        while (j++ < r) {
            Lawyer cur = queue.dequeue();
            copy.enqueue(cur);
            right.enqueue(cur);
        }

        while (!copy.isEmpty()) {
            queue.enqueue(copy.dequeue());
        }

        left = sortingSomeLawyer(left);
        right = sortingSomeLawyer(right);

        i = 0;
        j = 0;

        Comparator<Lawyer> c = (Lawyer l1, Lawyer l2) -> {
            if (l1.getHourlyWage() == l2.getHourlyWage()) {
                if (l1.getTotalIncome() > l2.getTotalIncome()) return -1;
                return 1;
            } else {
                if (l1.getHourlyWage() > l2.getHourlyWage()) return -1;
                return 1;
            }
        };

        while (!left.isEmpty() && !right.isEmpty()) {
            if (c.compare(left.front(), right.front()) == -1) {
                copy.enqueue(left.dequeue());
            } else {
                copy.enqueue(right.dequeue());
            }
        }

        while (!left.isEmpty()) {
            copy.enqueue(left.dequeue());
        }

        while (!right.isEmpty()) {
            copy.enqueue(right.dequeue());
        }

        return copy;
    }
}

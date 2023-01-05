package weblab;

import java.util.*;

class Solution {

    /**
     * Computes how fast the given tasks can be finished by the given number of TAs.
     * @param durations Array containing the duration for each tasks.
     * @param n Number of TAs to complete the tasks.
     * @return The shortest time in which all tasks can be completed.
     */
    public static int completeTasks(int[] durations, int n) {
        PriorityQueue<TA> q = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            q.add(new TA(0));
        }
        for (int i = 0; i < durations.length; i++) {
            TA cur = q.poll();
            cur.time += durations[i];
            q.add(cur);
        }
        while (q.size() != 1) {
            q.poll();
        }
        return q.poll().time;

    }
}
class TA implements Comparable<TA> {
    int time;
    public TA(int time) {
        this.time = time;
    }

    public int compareTo(TA t) {
        return this.time - t.time;
    }
}
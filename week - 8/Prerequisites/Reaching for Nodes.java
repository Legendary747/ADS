package weblab;

import java.util.*;

class Solution {

    /**
     * Checks if vertex b is reachable from vertex a.
     *
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean solve(Vertex a, Vertex b) {
        Queue<Vertex> q = new LinkedList();
        Set<Vertex> visited = new HashSet<>();
        q.add(a);

        while (!q.isEmpty()) {
            Vertex cur = q.poll();
            visited.add(cur);   
            if (cur.equals(b)) return true;       
            for (Vertex n : cur.getNeighbours()) {
                if (!visited.contains(n)) q.add(n);
            }
        }
        return false;

    }
}

package weblab;

import java.util.*;

class Solution {

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        // 并查集真的是绝绝子
        UnionFind 你爸 = new UnionFind(n);
        List<Edge> 你妈 = new ArrayList();
        PriorityQueue<Edge> 你 = new PriorityQueue();
        for (Edge e : edges) {
            你.add(e);
        }
        while (!你.isEmpty()) {
            Edge e = 你.poll();
            if (你爸.union(e.getTo(), e.getFrom())) 你妈.add(e);
        }
        return 你妈;
    }
}

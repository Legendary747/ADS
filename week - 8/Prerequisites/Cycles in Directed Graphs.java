package weblab;

import java.util.*;

class Solution {

    /**
     * Detects cycles in a connected component.
     *
     * @param s starting vertex in our connected component.
     * @param vertices the vertex that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static boolean detectCycle(Vertex s, List<Vertex> vertices) {
        // Use Dfs or Bfs to get all vertices in the current connect component
        // then loop over each of the vertices to see if there is a loop

        // // DFS 100 / 100
        // Stack<Vertex> stack = new Stack();
        // Set<Vertex> connected = new HashSet();
        // stack.push(s);
        // while (!stack.isEmpty()) {
        //     Vertex cur = stack.pop();
        //     connected.add(cur);
        //     for (Vertex n : cur.getOutgoingEdges()) {
        //         if (!connected.contains(n)) stack.push(n);
        //     }
        // }

        // BFS 100 / 100
        Queue<Vertex> q = new LinkedList();
        Set<Vertex> connected = new HashSet();
        q.add(s);

        while (!q.isEmpty()) {
            Vertex cur = q.poll();
            connected.add(cur);
            for (Vertex n : cur.getOutgoingEdges()) {
                if (!connected.contains(n)) q.add(n);
            }
        }

        for (Vertex v : connected) {
            if (detectCycle(v)) return true;
        }

        return false;
    }

    public static boolean detectCycle(Vertex s) {
        // Can also be written in DFS
        // but I did it above when collect the vertices
        // so I skip that here.

        // BFS
        Queue<Vertex> q = new LinkedList();
        Set<Vertex> visited = new HashSet();
        q.add(s);

        while (!q.isEmpty()) {
            Vertex cur = q.poll();
            visited.add(cur);
            for (Vertex n : cur.getOutgoingEdges()) {
                if (!visited.contains(n)) q.add(n);
                if (n.equals(s)) return true;
            }
        }
        return false;
    }

}

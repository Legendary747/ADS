package weblab;

import java.util.*;

class Solution {

    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g
     *     graph to search in.
     * @param v
     *     node to start from.
     * @param u
     *     node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        predecessors.put(v, null);
        GraphIterator iter = new GraphIterator(g, v);
        

        while (iter.hasNext()) {
            // this next vertex will be dad for all his neighbours
            Vertex next = iter.next();
            for (Vertex n : g.getNeighbours(next)) {
                // if it is in the map, then is is already shortest path
                // because for weight = 1 edges bfs can be used to run
                // the native spa;
                if (!predecessors.containsKey(n)) {
                    predecessors.put(n, next);
                }
            }
        }

        if (!predecessors.containsKey(u)) {
            return new ArrayList<Vertex>();
        } 
        LinkedList<Vertex> path = new LinkedList();
        while(u != null) {
            path.addFirst(u);
            u = predecessors.get(u);
        }
        System.out.println(path);
        return path;
    }
}

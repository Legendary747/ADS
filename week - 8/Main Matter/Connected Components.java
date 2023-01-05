package weblab;

import java.util.*;

class Solution {

    public static int numberOfConnectedComponents(Graph g) {
        if (g == null) return 0;
        if (g.getAllVertices().size() <= 1) return g.getAllVertices().size();
        
        // Use a set
        // remove is O(1) in hashset
        Set<Vertex> unexplored = new HashSet();
        unexplored.addAll(g.getAllVertices());
        int cnt = 0;
        while (!unexplored.isEmpty()) {
            cnt++;
            Vertex v = unexplored.iterator().next();
            GraphIterator iterator = new GraphIterator(g, v);
            while (iterator.hasNext()) {
                unexplored.remove(iterator.next());
            }
        }

        // //The remove is O (n) each time , so O (n^2) in total
        // //suprisingly not gettting time out, guess this can also work?
        // // use a list
        // List<Vertex> all = new ArrayList();
        // all.addAll(g.getAllVertices());
        // int cnt = 0;
        // while (all.size() > 0) {
        //     cnt++;
        //     Vertex v = all.get(0);
        //     GraphIterator iterator = new GraphIterator(g, v);
        //     while (iterator.hasNext()) {
        //         all.remove(iterator.next());
        //     }
        // }
        return cnt;
    }
}

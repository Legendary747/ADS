package weblab;

import java.util.*;

class Solution {

    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     *
     * @param g
     *     Graph to consider.
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {
        if (g == null || a == null || b == null) return null;

        AdaptablePQ pq = new AdaptablePQ();
        Map<Vertex, Vertex> pred = new HashMap();
        pred.put(a, null);
        int s = g.getAllVertices().size();
        int[] dist = new int[s];
        boolean[] vis = new boolean[s];
        for (int i = 0; i < s; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        vis[a.getId()] = true;
        dist[a.getId()] = 0;
        for(Vertex v : g.getAllVertices()){
           pq.insertOrReplace(v,dist[v.getId()]); // initialize vertex with distance MAX
           pred.put(v,null); // initial predessesor = null
       }

        while (!pq.isEmpty()) {
            Vertex cur = pq.removeMin().getVertex();
            if(dist[cur.getId()] == Integer.MAX_VALUE) break;
            vis[cur.getId()] = true;
            
            for (VertexNumPair nn : cur.getNeighbours()) {
                Vertex n = nn.getVertex();
                int w = nn.getNum();
                if (vis[n.getId()]) continue;
                int curDist = dist[cur.getId()] + w;
                if (dist[n.getId()] > curDist) {    
                    dist[n.getId()] = curDist;
                    pq.insertOrReplace(n, curDist);
                    pred.put(n, cur);
                }
            }
        }

        if (!vis[b.getId()]) return null;
        LinkedList<Vertex> ans = new LinkedList();
        while (b != null) {
            ans.addFirst(b);
            b = pred.get(b);
        }
        return ans;
    }
}

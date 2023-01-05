package weblab;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {

    private Graph g;

    private Vertex v;

    private Stack<Vertex> stack;

    private Set<Vertex> colored;

    private int graphSize;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.graphSize = g.getAllVertices().size();
        this.colored = new TreeSet<>();
        this.stack = new Stack();
        this.stack.push(v);
        colored.add(v);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Vertex next() {
        if (!hasNext()) return null;

        Vertex next = stack.pop();
        List<Vertex> ns = g.getNeighbours(next);
        Comparator<Vertex> cmp = (Vertex v1,Vertex v2) -> -(v1.getId() - v2.getId());
        Collections.sort(ns, cmp);
        for (int i = 0; i < ns.size(); i++) {
            if (!colored.contains(ns.get(i))) {
                stack.push(ns.get(i));
                colored.add(ns.get(i));
            }
        }
        return next;
    }
}

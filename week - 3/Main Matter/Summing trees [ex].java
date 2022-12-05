package weblab;
import java.util.*;

class Solution {

    /**
     * Sums the values of the nodes of two n-ary trees.
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return a new tree in which every node contains the sum of the values of the nodes at the corresponding positions in t1 and t2
     */
    public static Tree sum(Tree t1, Tree t2) {
        if (t1 == null) return null;
        int sum = t1.getValue() + t2.getValue();
        Tree newTree = new Tree(sum);
        List<Tree> l = t1.getChildren();
        List<Tree> r = t2.getChildren();
        for (int i = 0; i < l.size(); i++) {
            newTree.getChildren().add(
                sum(l.get(i), r.get(i))
            );
        }
        return newTree;
    }
}

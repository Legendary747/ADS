package weblab;

import java.util.*;

public class Solution {

    /**
     * Creates a hard copy of the n-ary tree.
     * @param t The tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding positions in t
     */
    public static Tree copy(Tree t) {
        if (t == null) return t;
        Tree root = new Tree(t.getValue(), new ArrayList());
        for (Tree tt : t.getChildren()){
            root.getChildren().add(copy(tt));
        }
        return root;
    }
}

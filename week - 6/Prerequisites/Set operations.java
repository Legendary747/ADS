package weblab;

import java.util.*;

class MySet extends HashSet<String> {

    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * Unions this set with the given other set.
     *
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        for (String s : this) {
            result.add(s);
        }
        if (that == null) return result;
        for (String s : that) {
            if (!result.contains(s)) result.add(s);
        }

        return result;
    }

    /**
     * Intersects this set with the given other set.
     *
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if (that == null) return result;
        for (String s : this) {
            if (that.contains(s)) result.add(s);
        }
        return result;
    }

    /**
     * Gets the difference between this set and the given other set.
     *
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            for (String s : this) {
                result.add(s);
            }
            return result;
        }
        for (String s : this) {
            if (!that.contains(s)) result.add(s);
        }
        return result;
    }

    /**
     * Gets the exclusive or between this set and the given other set.
     *
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            for (String s : this) {
                result.add(s);
            }
            return result;
        }
        MySet intersect = intersection(that);
        MySet union = union(that);
        for (String s : union) {
            if (!intersect.contains(s)) result.add(s);
        }
        return result;
    }

    /**
     * Converts this set to a string representation.
     *
     * @return a String representation of a MySet object
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<MySet{");
        Iterator inter = this.iterator();
        while (inter.hasNext()) {
            String s = (String) inter.next();
            sb.append(s);
            if (inter.hasNext()) sb.append(",");
        }
        sb.append("}>");
        System.out.println(sb);
        return sb.toString();
    }
}

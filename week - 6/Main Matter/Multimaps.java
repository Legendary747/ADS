package weblab;

import java.util.*;

class MultiMap {

    private Map<Integer, List<Integer>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        map = new HashMap();
    }

    /**
     * Gets the size of this MultiMap.
     *
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        int cnt = 0;
        for (Integer k : map.keySet()) {
            cnt += map.get(k).size();
        }
        return cnt;
    }

    /**
     * Gets whether this MultiMap is empty.
     *
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            map.put(key, new ArrayList<Integer>());
            map.get(key).add(value);
        }
        // TODO
    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return new ArrayList<Integer>();
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        if (map.containsKey(key)) {
            for (int i = 0; i < map.get(key).size(); i++) {
                if (map.get(key).get(i) == value) {
                    map.get(key).remove(i);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}

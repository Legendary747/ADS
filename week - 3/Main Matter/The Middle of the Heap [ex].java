class Solution {
  /**
   * @param heap
   *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
   * @return the Node corresponding to the middle element in the last layer of the Heap, or null if the Heap is null.
   * In case the last layer contains an even number of elements, returns the element just left of the middle (see test).
   */
  public static Heap.Node findMiddleInLastLayer(Heap heap) {
    if (heap == null) return null;
    if(heap.size() == 1){
        Heap.Node tmp = heap.getRoot();
        return tmp;
    }
    int n = heap.size();
    int h = 1; // nodes before last level
    int h_c = 0; // height counter
    int old = h;

    while(old < n){ // calculate the height
        h *= 2; // nodes in the last layer [max]
        old += h;
        h_c++;
    }
    
    int[] direction = new int[h_c]; // bit preperation
    int mid_index = (h-(old-n)-1)/2;
    int index = 0;

    while(mid_index != 0){
        int tmp = mid_index%2;
        mid_index /= 2;
        direction[index++] = tmp;
    }
    for(int i = index;i<h_c;i++){
        direction[i] = 0;
    }

    Heap.Node tmp = heap.getRoot();

    for(int i = direction.length-1;i>=0;i--){
        if(direction[i] == 0) tmp = heap.getLeft(tmp);
        else tmp = heap.getRight(tmp);
    }
    return tmp;
  }
}
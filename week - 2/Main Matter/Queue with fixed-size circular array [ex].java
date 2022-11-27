package weblab;

class ArrayQueue {

    private int[] arr;

    private int head;

    private int size;

    /**
     * Creates a new ArrayQueue with the given capacity.
     * @param capacity the capacity for this queue
     */
    public ArrayQueue(int capacity) {
        this.arr = new int[capacity];
        size = 0;
        head = arr[0];
    }

    /**
     * Adds the given element to the queue.
     * @param e the element to add to the queue
     * @throws FullQueueException if the queue is full
     */
    public void enqueue(int e) throws FullQueueException {
        // Notice that we don't have an tail
        // but we could easily consturct a tail while knowing
        // tail = head + queue size
        // to make the array circular, use module to prevent index out of bound
        if (arr.length == size) throw new FullQueueException();
        arr[(size + head) % arr.length] = e;
        size++;
    }

    /**
     * Removes an element from the queue and returns it.
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public int dequeue() throws EmptyQueueException {
        if (size == 0) throw new EmptyQueueException();
        int ans = arr[head];
        size--;
        head = (head + 1) >= arr.length ? (head + 1) % arr.length : head+1;
        return ans;
    }

    public static void print(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        System.out.println(s);
    }

    public int[] getArr() {
        return this.arr;
    }
}

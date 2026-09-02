class MyCircularQueue {
    private int[] buffer;
    private int front;
    private int size;

    public MyCircularQueue(int k) {
        buffer = new int[k];
        front = 0; // it's just the index
        size = 0;
    }

    public boolean enQueue(int value) {
        if (size == buffer.length)
            return false;

        // the next free position is immediately after the current logical Queue

        int insert_idx = (front + size) % buffer.length;
        buffer[insert_idx] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if(size == 0)
            return false;

        // move the front forward
        front = (front + 1) % buffer.length;
        size--;

        return true;
    }

    public int Front() {
        if(size == 0)
            return -1;

        return buffer[front];
    }

    public int Rear() {
        if(size == 0)
            return -1;

        int rear_idx = (front + size - 1) % buffer.length;
        return buffer[rear_idx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
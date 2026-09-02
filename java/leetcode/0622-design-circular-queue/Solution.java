class MyCircularQueue {
    private ArrayDeque<Integer> buffer;
    private int limit;

    public MyCircularQueue(int k) {
        limit = k;
        buffer = new ArrayDeque<>(limit);
    }
    
    public boolean enQueue(int value) {
        // sanity check if the buffer is full first... if yes, return false
        boolean result;

        if(buffer.size() == limit){
            result = false;
        }else{
            buffer.add(value);
            result = true;
        }

        return result;
    }
    
    public boolean deQueue() {
        // sanity check if the buffer is empty first... if yes, return false
        boolean result;

        if(buffer.isEmpty()){
            result = false;
        }else{
            buffer.poll();
            result = true;
        }

        return result;
    
    }
    
    public int Front() {
        return (buffer.peek() == null)
                ? -1
                : buffer.peekFirst();
    }
    
    public int Rear() {
        return (buffer.peek() == null)
                ? -1
                : buffer.peekLast();
    }
    
    public boolean isEmpty() {
        return buffer.isEmpty();
    }
    
    public boolean isFull() {
        return (buffer.size() == limit);
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
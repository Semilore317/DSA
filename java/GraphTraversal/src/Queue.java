import java.util.LinkedList;
// Assuming 'Vertex' is another class you have defined

public class Queue<Vertex> {

    // Use Generics for better type safety
    public LinkedList<Vertex> queue;
    // We can remove 'size' since LinkedList has a size() method

    public Queue() {
        this.queue = new LinkedList<Vertex>();
        // this.size = 0; // Not needed
    }

    public boolean isEmpty() {
        // Use the built-in size() method
        return this.queue.size() == 0;
        // Or even simpler: return this.queue.isEmpty();
    }

    public void enqueue(Vertex data) {
        // 'addLast(E e)' adds an element to the end (tail) of the list,
        // which is the correct operation for adding to a Queue.
        this.queue.addLast(data);
        // this.size++; // Not needed
    }

    public Vertex peek() {
        // 'peekFirst()' returns the head of the list, or 'null' if the list is empty.
        // This is safer and cleaner than checking isEmpty() first.
        return this.queue.peekFirst();
    }

    public Vertex dequeue() {
        // 'removeFirst()' removes and returns the head of the list.
        // It throws a NoSuchElementException if the list is empty,
        // which is often preferred over throwing a generic Error.
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty!");
        } else {
            // Alternatively, use 'pollFirst()' which returns null if empty and doesn't throw an exception.
            return this.queue.removeFirst();
            // this.size--; // Not needed
        }
    }
}
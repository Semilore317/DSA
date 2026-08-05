// Fundamentals - Array
package dsa.fundamentals;
public class Array<S> {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // resize array if full
        if (count == items.length) {
            // create a new larger array
            int[] newItems = new int[count * 2];

            // copy existing items
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // add new item at the end of the array
            items = newItems;
        }
    }

    public void remove(int item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = 0;
            }
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println(); // Adds a newline for better output
    }


    public void main(String[] args) {
        Array<S> numbers = new Array<S>(10);
        numbers.print();
        numbers.insert(10);
        numbers.insert(20);
        numbers.remove(10);
        numbers.print();
    }
}
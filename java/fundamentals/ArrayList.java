// Fundamentals - ArrayList

import java.util.ArrayList;

public class ArrayList {
    public static void main(String[] args) {
        // ArrayLists grow by 50% of their current size
        // vectors grow by 100% of their current size
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(0);
        System.out.println(list.indexOf("C"));
        list.toArray();
    }
}
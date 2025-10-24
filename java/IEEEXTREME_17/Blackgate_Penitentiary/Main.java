package IEEEXTREME_17.Blackgate_Penitentiary;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> heightRoster = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            heightRoster.put(name, height);
        }
        sc.close();

        // treeMap -> auto-sorts heights in ASCENDING order
        Map<Integer, List<String>> groups = new TreeMap<>();

        // group by height
        for (Map.Entry<String, Integer> entry : heightRoster.entrySet()) {
            int height = entry.getValue();
            groups.putIfAbsent(height, new ArrayList<>());
            groups.get(height).add(entry.getKey());
        }

        // sort names alphabetically within each height
        for (List<String> names : groups.values()) {
            Collections.sort(names);
        }

        // compute position ranges
        int currentPos = 1;
        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
            List<String> names = entry.getValue();
            int count = names.size();

            int minPos = currentPos;
            int maxPos = currentPos + count - 1;
            currentPos += count;

            // output
            System.out.print(String.join(" ", names));
            System.out.println(" " + minPos + " " + maxPos);
        }
    }
}

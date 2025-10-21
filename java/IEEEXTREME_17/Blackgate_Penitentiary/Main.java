package IEEEXTREME_17.Blackgate_Penitentiary;

import java.util.*;

class Main {

    public static LinkedHashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        return hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                    LinkedHashMap::new,
                    (m, e) -> m.put(e.getKey(), e.getValue()),
                    LinkedHashMap::putAll
                );
    }

    public static <K, V> List<K> getKeysByValue(Map<K, V> map, V value) {
        List<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static void blackGate(HashMap<String, Integer> roster) {
        HashMap<String, Integer> sortedRoster = sortByValue(roster);

        List<Integer> heights = new ArrayList<>(sortedRoster.values());
        HashSet<Integer> uniqueHeights = new HashSet<>(heights);

        for (Integer height : uniqueHeights) {
            List<String> sameHeight = getKeysByValue(sortedRoster, height);
            System.out.println("Height " + height + ": " + sameHeight);
        }

        System.out.println("Number of unique height groups: " + uniqueHeights.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> heightRoster = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            heightRoster.put(name, height);
        }

        blackGate(heightRoster);
        sc.close();
    }
}

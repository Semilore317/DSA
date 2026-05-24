// HackerRank - OrganizingContainers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Long.sum;

public class OrganizingContainers {
    public static String organizingContainers(List<List<Integer>> container){
        int n = container.size();
        long[] containerSizes = new long[n];
        long[] ballTypes = new long[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = container.get(i).get(j);
                containerSizes[i] += value;
                ballTypes[j] += value;
            }
        }

        Arrays.sort(containerSizes);
        Arrays.sort(ballTypes);

        return Arrays.equals(containerSizes, ballTypes) ? "Possible" : "Impossible";
    }
    public static void main(String[] args) {
        List<List<Integer>> container = new ArrayList<>();
        List<Integer> container_1 = new ArrayList<>();
        container_1.add(1);
        container_1.add(4);
        List<Integer> container_2 = new ArrayList<>();
        container_2.add(2);
        container_2.add(3);

        container.add(container_1);
        container.add(container_2);

        for(List<Integer> list : container) {
            for (Integer integer : list) {
                System.out.print(STR."\{integer}\t");
            }
            System.out.println("\n");
        }
    }
}

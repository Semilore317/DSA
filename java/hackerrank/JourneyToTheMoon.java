// HackerRank - JourneyToTheMoon

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JourneyToTheMoon {
    /* NAIVE APPROACH */
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // given an integer n
        // the astronauts_ids = {0,1,...,n-1}
        int valid_pairs = 0;
        List<Integer> id_s = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            id_s.add(i);
        }

        // certain astronauts can be from multiple countries
        // create value pair for e
        return valid_pairs;
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> astronaut = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(2, 3))
        ));
        System.out.println(journeyToMoon(n, astronaut));
    }
}

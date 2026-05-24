// LeetCode #875 - Koko Eating Bananas

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        if (piles.length == 1) {
            return (piles[0] + H - 1) / H; // Single pile
        }
        int left = 1;
        int right = 1000000000;

        while (left < right) {
            int mid = (left + right) / 2;
            int total = 0;
            for (int pile : piles)
                //total += (int) Math.ceil((double) pile / mid);
                total += (pile + mid - 1) / mid;
                if(total > H) break;
            if (total > H)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] piles = {1000000000};
        int H = 2;
        KokoEatingBananas solution = new KokoEatingBananas();
        System.out.println(solution.minEatingSpeed(piles, H));
    }
}
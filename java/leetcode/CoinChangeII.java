// LeetCode #518 - Coin Change II

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1; // base case

        // update the amount for each coin denomination
        for (int coin : coins) {
            for (int n = Math.min(coin, amount); n < arr.length; n++) {
                if (coin <= n){
                    arr[n] += arr[n - coin];
                }
            }
        }

        return arr[amount];
    }
    public static void main(String[] args) {
        problem_518 problem = new problem_518();
        System.out.println(problem.change(5, new int[]{1, 2, 5}));
    }
}

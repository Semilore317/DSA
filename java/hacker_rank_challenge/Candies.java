package hacker_rank_challenge;

import java.util.List;
// ...
public class Candies{
    public static long candies(int n, List<Integer> arr){
        // children with the same rating can have different candies
        // when two children are adjacent, the one with a higher rating must have more candy than the one with less
        
        int[] candies = new int[n];

        // all kids must have at least one candy
        for(int i = 0; i < n; i++){
            candies[i] = 1;
        }

        // iterating from left to right
        for (int i = 0 ; i < n; i++){
            if(i > 0 && arr.get(i) > arr.get(i - 1)){
                candies[i] = candies[i - 1] + 1;
            }
        }

        // iterating from right to left
        for (int i = n - 2; i >= 0; i--){
            if(arr.get(i) > arr.get(i + 1)){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        long totalCandies = 0;
        for(int candy : candies){
            totalCandies += candy;
        }
        return totalCandies;
}
    public static void main(String[] args) {
        int n = 10; // number of children
        List<Integer> arr = List.of(2, 4, 2, 6, 1, 7, 8, 9, 2, 1);  // ratings of each child
        System.out.println(candies(n, arr));   
    }
}
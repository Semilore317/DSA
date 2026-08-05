// LeetCode #739 - Daily Temperatures

import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /* SOLUTION 1: STACK*/
        // for each temperature in temperature
        // iterate through the array till there's a higher value
        // return their difference
        // else return 0 - default array value

        /*
        int[] temp = {77, 65, 74, 78};
        int[] result = {0, 0, 0, 0};
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                res[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }
        return res;
        */

        /* SOLUTION 2: ARRAY */
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--];
                result[index] = i - index;
            }
            stack[++top] = i;
        }
        return result;

    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));
    }
}

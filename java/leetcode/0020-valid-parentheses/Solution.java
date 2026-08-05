// LeetCode #20 - Valid Parentheses

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static int longestValidParentheses(String s) {
        HashMap<Character, Character> map = new HashMap<>();
          map.put('(', ')');
          map.put('[', ']');
          map.put('{', '}');
        // EDGE CASES
        //1. EMPTY STRING
        if(s == null) return 0;

        int longest_parentheses = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            if (map.containsKey(current_char)) {
                // if it's an opening bracket, push its index onto the stack
                stack.push(i);
            } else {
                // if it's a closing bracket, pop the top of the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    //after popping, if the stack is empty, this means:
                    //the closing bracket didn't have a matching open bracket (extra )),
                    //push its index as a new base for future valid substring lengths
                    stack.push(i);
                } else {
                    // calculate the length of the current valid substring
                    longest_parentheses = Math.max(longest_parentheses, i - stack.peek());
                }
            }
        }
        return longest_parentheses;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}

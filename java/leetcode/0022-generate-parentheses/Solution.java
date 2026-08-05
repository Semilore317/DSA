// LeetCode #22 - Generate Parentheses

import java.util.HashMap;
import java.util.List;

/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/
public class Solution {
    // generate all the possible parenthese matches
    // check if they are valid using a separate valid parenthese checker
    // return the valid parenthesis
    public List<String> generateParenthesis(int n){
        HashMap parentheses = new HashMap();
        parentheses.put(")", "(");

        return (List<String>) parentheses;

    }
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.generateParenthesis(3));
    }
}

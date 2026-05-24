# LeetCode #22 - Generate Parentheses
"""
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
"""

class Solution:
    def generateParenthesis:
        self.result = []

        def backtrack(current, open_count, close_count, n):
            if len(current) == 2 * n:
                self.result.append(current)
                return
            if open_count < n:
                backtrack(current + '(', open_count + 1, close_count, n)
            if close_count < open_count:
                backtrack(current + ')', open_count, close_count + 1, n)

        backtrack('', 0, 0, n)
        return self.result
    def generateParenthesis(self, n: int) -> list[str]:
        self.result = []

        def backtrack(current, open_count, close_count, n):
            if len(current) == 2 * n:
                self.result.append(current)
                return
            if open_count < n:
                backtrack(current + '(', open_count + 1, close_count, n)
            if close_count < open_count:
                backtrack(current + ')', open_count, close_count + 1, n)

        backtrack('', 0, 0, n)
        return self.result
        
# LeetCode #997 - Find the Town Judge
"""
997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:
Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
"""

from collections import Counter

trust = [[1,2],[2,3]]
n = 3


class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """

        # town judge musn't trust anyone
        # everyone except the judge trusts the judge


        judge_arr = []
        people_arr = []
        for trust_relation in trust:
            judge_arr.append(trust_relation[1])
            people_arr.append(trust_relation[0])
        
        # Remove people who trust others from judge candidates
        judge_candidates = set(judge_arr) - set(people_arr)
        
        if not judge_candidates:
            return -1 if n > 1 else 1  # Handle case where n=1 and no trust relations
        
        # Check if any candidate is trusted by n-1 people
        counter = Counter(judge_arr)
        for candidate in judge_candidates:
            if counter[candidate] == n - 1:
                return candidate
        
        return -1

print(Solution().findJudge(n, trust))
# LeetCode #128 - Longest Consecutive Sequence
"""
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3
"""

#nums = [100, 4, 200, 1, 3, 2]
#nums = [0,3,7,2,5,8,4,6,0,1]
#nums = [1,1,0,1,2]
#nums = []
nums = [9,1,4,7,3,-1,0,5,8,-1,6]

class Solution:
    def longestConsecutive(self, nums):
        nums = set(nums)
        longest_len = 0
        hash = dict()
        for num in nums:
            # get the length for num - 1 sequence formed so far
            l = hash.get(num - 1, 0)
            # get the length for num + 1 sequence formed so far
            r = hash.get(num + 1, 0)
            # calculate the current sequnce length possible
            curr_len = r + l + 1
            # set the sequence length for starting index
            # to find starting index just subtract current num - l
            # think: each step was 1 and we just moved l*1 from num to get the start
            hash[num - l] = curr_len
            # similar for the rightmost
            hash[num + r] = curr_len
            longest_len = max(curr_len, longest_len)
        return longest_len

print(Solution().longestConsecutive(nums))
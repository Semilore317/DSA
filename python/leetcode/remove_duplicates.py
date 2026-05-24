# LeetCode #26 - Remove Duplicates from Sorted Array
"""
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
"""
nums = [0,0,1,1,1,2,2,3,3,4]
#nums = [1,1,2]

def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    n = len(nums)
    if n == 0:
        return 0

    j = 1

    for i in range(1, n):
        if nums[i] != nums[i - 1]:
            nums[j] = nums[i]
            j += 1

    return j


print(removeDuplicates(nums))
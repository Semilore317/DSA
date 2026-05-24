# LeetCode #283 - Move Zeroes
"""
Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
"""

#nums = [0,1,0,3,12]

nums = [1,2,3,0,3,4]

def moveZeroes(nums):
    """
    :type nums: List[int]
    :param nums:
    :return:
    """

    """
    NAIVE APPROACH - works but with shit runtime but good storage
    for num in nums:
        if num == 0:
            nums.remove(num)
            nums.append(0)
    """

    border = 0  #demarcation between zeroes and ones

    for i in range(len(nums)):
        if nums[i] != 0:
            nums[border] = nums[i]
            border += 1

    for i in range(border, len(nums)):
        nums[i] = 0

    return nums

print(moveZeroes(nums))
# LeetCode #69 - Sqrt(x)
"""
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
"""

import time
def mySqrt(x):
    start = time.time()
    # edge cases
    # 1. negative input
    if x < 0:
        raise TypeError("Input must be a positive integer")

    # 2. x is 0 or 1
    if x == 0 or x == 1:
        return x

    # Binary search to find the integer square root
    left = 1
    right = x // 2

    while left <= right:
        mid = (left + right) // 2
        square = mid * mid

        if square == x:
            return mid
        elif square < x:
            left = mid + 1
        else:
            right = mid - 1

    # Return the largest integer y such that y * y <= x
    end = time.time()
    runtime = (end - start) * 1000
    return right, runtime




print(mySqrt(4))
print(mySqrt(8))
print(mySqrt(1000))
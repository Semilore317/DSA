# LeetCode #67 - Add Binary
"""
Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
"""
a = "1010"
b = "1011"
def addBinary(a, b):
    # algorithm to convert from binary to decimal
    den_a = int(a, 2)
    den_b = int(b, 2)

    return bin(int(str(den_a + den_b)))[2:]



print(addBinary(a, b))
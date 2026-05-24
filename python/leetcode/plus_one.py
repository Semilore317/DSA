# LeetCode #66 - Plus One
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        # iterate from the rightmost digit and check if it's 9
        # if it isn't, increment by one
        # if it isn't continue and carry over the increment

        n = len(digits)

        # Iterate from the rightmost digit to the leftmost
        for i in range(n - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits  # No carry-over, so return the modified list
            else:
                digits[i] = 0  # Current digit is 9, set to 0 and carry over

        # If all digits were 9s (e.g., [9,9,9]), a carry-over remains
        # Prepend a 1 to the list
        return [1] + digits

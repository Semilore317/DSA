# LeetCode #682 - Baseball Game
class Solution(object):
    def calPoints(self, operations):
        """
        :type operations: List[str]
        :rtype: int
        """

        record = []
        for operation in operations:
            if operation == '+':
                record.append(record[-1]+record[-2])
            elif operation == 'D':
                record.append(2*record[-1])
            elif operation == 'C':
                record.pop(-1)
            else:
                record.append(int(operation))
        return sum(record)
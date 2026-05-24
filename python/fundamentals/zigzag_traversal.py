# Fundamentals - zigzag_traversal
from collections import deque
import Traversal


class ZigZagTraversal:
    def zigZag(self, root):
        """Perform zig-zag level-order traversal and return node values."""
        result = []
        if not root:
            return result

        queue = deque([root])
        left_to_right = True

        while queue:
            level_size = len(queue)
            current_level = []

            # Process all nodes at the current level
            for _ in range(level_size): # _ indicates that the loop variable is irrelevant
                node = queue.popleft()
                current_level.append(node.data)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            # Reverse the current level if going right-to-left
            if not left_to_right:
                current_level.reverse()

            result.extend(current_level)
            left_to_right = not left_to_right  # Toggle direction for next level

        return result


def main():
    # Test Case 1: Tree 1
    #       10
    #      /  \
    #     5    15
    #    / \     \
    #   3   7    18
    root1 = Traversal.Node(10)
    root1.left = Traversal.Node(5)
    root1.right = Traversal.Node(15)
    root1.left.left = Traversal.Node(3)
    root1.left.right = Traversal.Node(7)
    root1.right.right = Traversal.Node(18)

    # Test Case 2: Tree 2
    #       10
    #      /  \
    #     5    15
    #    / \    /
    #   3   7  12
    root2 = Traversal.Node(10)
    root2.left = Traversal.Node(5)
    root2.right = Traversal.Node(15)
    root2.left.left = Traversal.Node(3)
    root2.left.right = Traversal.Node(7)
    root2.right.left = Traversal.Node(12)

    # Test zig-zag traversal
    zigzag = ZigZagTraversal()
    print("Test Case 1 (Tree 1):")
    print("Zig-zag traversal:", " ".join(map(str, zigzag.zigZag(root1))), "\n")

    print("Test Case 2 (Tree 2):")
    print("Zig-zag traversal:", " ".join(map(str, zigzag.zigZag(root2))))


if __name__ == "__main__":
    main()
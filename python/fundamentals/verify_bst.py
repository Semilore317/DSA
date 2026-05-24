# Fundamentals - verify_bst
import Traversal

class VerifyBST:
    def __init__(self, root):
        self.root = root

    def verifyBST(self):
        def isValidBST(node, min_val, max_val):
            if not node:
                return True
            if node.data <= min_val or node.data >= max_val:
                return False
            return (isValidBST(node.left, min_val, node.data) and
                    isValidBST(node.right, node.data, max_val))

        # Verify BST property
        is_valid = isValidBST(self.root, float('-inf'), float('inf'))

        # Print in-order traversal
        traversal = Traversal.Traversal()
        in_order = traversal.inOrder(self.root)
        print("In-order traversal:", " ".join(map(str, in_order)))

        # Confirm in-order is sorted
        is_sorted = all(in_order[i] <= in_order[i + 1] for i in range(len(in_order) - 1)) if in_order else True

        return is_valid and is_sorted

# Testing
def main():
    # Test Case 1: Valid BST
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

    # Test Case 2: Invalid BST
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
    root2.right.left = Traversal.Node(12)  # Violates BST: 12 < 15 but in left-subtree

    # Run tests
    print("Test Case 1 (Valid BST):")
    bst1 = VerifyBST(root1)
    print(f"Is valid BST? {bst1.verifyBST()}\n")

    print("Test Case 2 (Invalid BST):")
    bst2 = VerifyBST(root2)
    print(f"Is valid BST? {bst2.verifyBST()}")

if __name__ == "__main__":
    main()
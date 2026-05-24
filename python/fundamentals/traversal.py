# Fundamentals - traversal
from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Traversal:
    def preOrder(self, node):
        """Perform pre-order traversal (Root, Left, Right) and return node values."""
        result = []
        if node:
            result.append(node.data)
            result.extend(self.preOrder(node.left))
            result.extend(self.preOrder(node.right))
        return result

    def inOrder(self, node):
        """Perform in-order traversal (Left, Root, Right) and return node values."""
        result = []
        if node:
            result.extend(self.inOrder(node.left))
            result.append(node.data)
            result.extend(self.inOrder(node.right))
        return result

    def postOrder(self, node):
        """Perform post-order traversal (Left, Right, Root) and return node values."""
        result = []
        if node:
            result.extend(self.postOrder(node.left))
            result.extend(self.postOrder(node.right))
            result.append(node.data)
        return result

    def levelOrder(self, node):
        """Perform level-order traversal (breadth-first) and return node values."""
        result = []
        if not node:
            return result
        queue = deque([node])
        while queue:
            current = queue.popleft()
            result.append(current.data)
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)
        return result

# Testing the Traversal class
def main():
    # Create a sample binary tree:
    """
        A
       / \
      B   C
    /  \    \
   D    E    F
    """
    root = Node("A")
    root.left = Node("B")
    root.right = Node("C")
    root.left.left = Node("D")
    root.left.right = Node("E")
    root.right.right = Node("F")

    # Instantiate Traversal class
    traversal = Traversal()

    # Test each traversal method
    print("Pre-order traversal:", " ".join(map(str, traversal.preOrder(root))))
    print("In-order traversal:", " ".join(map(str, traversal.inOrder(root))))
    print("Post-order traversal:", " ".join(map(str, traversal.postOrder(root))))
    print("Level-order traversal:", " ".join(map(str, traversal.levelOrder(root))))

# Run the main function
if __name__ == "__main__":
    main()
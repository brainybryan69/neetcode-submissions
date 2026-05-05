# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = None

        def inOrder(node):
            nonlocal count
            nonlocal result

            if not node:
                return
            
            inOrder(node.left)

            count += 1
            if count == k:
                result = node.val
                return

            inOrder(node.right)
        
        inOrder(root)
        return result
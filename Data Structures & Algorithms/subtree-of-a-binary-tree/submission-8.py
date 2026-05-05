# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def isSameTree(p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
            if not p and not q:
                return True
            elif p and not q or q and not p:
                return False
            
            valsEqual = p.val == q.val
            leftEqual = isSameTree(p.left, q.left)
            rightEqual = isSameTree(p.right, q.right)
            
            return valsEqual and leftEqual and rightEqual

        if not root and subRoot:
            return False
        if isSameTree(root, subRoot):
            return True
        else:
            return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
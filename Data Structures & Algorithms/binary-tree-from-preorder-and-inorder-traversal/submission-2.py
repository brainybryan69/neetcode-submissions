# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return
            
        root = TreeNode(preorder[0])

        index = -1
        for i in range(len(inorder)):
            if inorder[i] == preorder[0]:
                index = i
                break

        inorderLeft, inorderRight = inorder[:index], inorder[index + 1:]
        preorderLeft, preorderRight = preorder[1:index + 1], preorder[index + 1:]

        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)

        return root
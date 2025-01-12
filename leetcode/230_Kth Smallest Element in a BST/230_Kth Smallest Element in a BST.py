# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

N, K = 0, 0
ans = 0

def rcs(root):
    global N, ans
    # base case
    if root is None:
        return

    rcs(root.left)
    N += 1
    if N == K:
        ans = root.val
        return
    rcs(root.right)

    return

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        global N, K, ans
        N = 0
        K = k
        ans = 0
        rcs(root)
        return ans
        
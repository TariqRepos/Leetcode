/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sol;
    public int maxPathSum(TreeNode root) {
        sol = Integer.MIN_VALUE;
        pathSum(root);
        return sol;
    }
    public int pathSum(TreeNode node) {
        if(node == null)
            return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        sol = Math.max(sol, left + right + node.val);
        return Math.max(left, right) + node.val; // Max gain from this particular node
    }
}
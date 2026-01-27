// https://leetcode.com/problems/subtree-of-another-tree/description/
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return dfs(root,subRoot);
    }
    private boolean dfs(TreeNode node,TreeNode sub){
        if(node==null) return false;
        if(node.val==sub.val && isSame(node,sub)) return true;
        return dfs(node.left,sub) || dfs(node.right,sub);
    }
    private boolean isSame(TreeNode x,TreeNode y){
        if(x == null && y == null) return true;
        if((x == null && y != null)|| (x != null && y == null)) return false;
        if(x.val != y.val) return false;
        boolean left = isSame(x.left, y.left);
        boolean right = isSame(x.right, y.right);
        return left && right;
    }
}
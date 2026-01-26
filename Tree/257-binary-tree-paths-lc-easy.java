// https://leetcode.com/problems/binary-tree-paths/
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
    List<String> ls = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ls;
    }
    public void dfs(TreeNode root, StringBuilder sb) {
        int len = sb.length();
        sb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            ls.add(sb.toString());
            return;
        }
        if(root.left != null) {
            dfs(root.left, sb.append("->"));
            sb.setLength(len + String.valueOf(root.val).length());
        }
        if(root.right != null) {
            dfs(root.right, sb.append("->"));
            sb.setLength(len + String.valueOf(root.val).length());
        }
    }
}
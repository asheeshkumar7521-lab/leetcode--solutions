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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=diameterOfBinaryTree(root.left);
        int r=diameterOfBinaryTree(root.right);
        int lh=Hight(root.left);
        int rh=Hight(root.right);
        int self=(lh+rh+2);
        return Math.max(self,Math.max(l,r));
    }
    public int Hight(TreeNode root){
        if(root==null){
            return -1;
        }
        int l=Hight(root.left);
        int r=Hight(root.right);
        return 1 + Math.max(l, r);
    }
}
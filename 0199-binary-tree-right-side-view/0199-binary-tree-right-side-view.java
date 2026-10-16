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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        solve(root,1,list);
        return list;

    }
    int visited= 0;
    public void solve(TreeNode root, int cl, List<Integer> list){
        if(root==null){
            return;
        }
        if(visited<cl){
            list.add(root.val);
            visited=cl;
        }
        solve(root.right,cl+1,list);
        solve(root.left,cl+1,list);
        
    }
}

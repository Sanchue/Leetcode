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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checker(root1,root2);
    }
    private boolean checker(TreeNode n1,TreeNode n2)
    {
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null || n2.val!=n1.val) return false;
        return (checker(n1.left,n2.left)|| checker(n1.left,n2.right)) && (checker(n1.right,n2.right) ||checker(n1.right,n2.left));
    }
}

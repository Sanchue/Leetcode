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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int cursum=root.val;
        while(!q.isEmpty())
        {
            int levelsum=0;
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode cur=q.poll();
                cur.val=cursum-cur.val;
                int child=(cur.left!=null?cur.left.val:0) + (cur.right!=null?cur.right.val:0);
                levelsum+=child;
                if(cur.left!=null)
                {
                    cur.left.val=child;
                    q.add(cur.left);
                }
                if(cur.right!=null)
                {
                    cur.right.val=child;
                    q.add(cur.right);
                }
            }
            cursum=levelsum;
        }
        return root;
    }
}

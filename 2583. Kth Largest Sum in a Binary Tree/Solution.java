class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        if(root==null) return -1;
        queue.offer(root);
        int a=0;
        long sum=0;
        ArrayList<Long> list=new ArrayList<>();
        long x=root.val;
        list.add(x);
        while(!queue.isEmpty())
        {
            int n=queue.size();
            sum=0;
            for(int i=0;i<n;i++)
            {
                if(queue.peek().left!=null)
                {
                    sum+=queue.peek().left.val;
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null)
                {
                    sum+=queue.peek().right.val;
                    queue.offer(queue.peek().right);
                }
                queue.poll();  
                
            }
            list.add(sum);
        }
        Collections.sort(list);
        list.remove(0);
        if(list.size()<k) return -1;
        return list.get(list.size()-k);
    }
}

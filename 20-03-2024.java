class Solution{
   class Res
    {
        int maxSum = Integer.MIN_VALUE; 
        int maxLen = 0; 
    };
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        Res r = new Res();
        Res s = new Res();
        if(root == null)
          return 0;
        
        sumOfLongRootToLeafPathUtil(root, 0, 0, s, r); 
        return r.maxSum;
    }
    public void sumOfLongRootToLeafPathUtil(Node root, int sum, int len, Res s, Res r)
    {
        if(root == null) 
        {
        if (s.maxLen < len) 
        {
            s.maxLen = len; 
            r.maxSum = sum; 
        }
        else if (s.maxLen == len && r.maxSum < sum)
            r.maxSum = sum;
            return;
        }
        sumOfLongRootToLeafPathUtil(root.left, sum + root.data, len + 1, s, r);
        sumOfLongRootToLeafPathUtil(root.right, sum + root.data, len + 1,s, r);
    }
};

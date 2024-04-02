class Solution
{
    int min = Integer.MAX_VALUE; 
    Integer prev = null;
    int absolute_diff(Node root)
    {
         if (root == null) return min; 
        
        absolute_diff(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.data - prev); 
        }
        prev = root.data; 
        
        absolute_diff(root.right); 
        
        return min;
    }

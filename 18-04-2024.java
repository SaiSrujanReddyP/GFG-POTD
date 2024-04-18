class Solution
{
    public int[] twoRepeated(int arr[], int n)
    {
        boolean first = false;
        int[] res = new int[2];
        for(int p=0;p<n+2;p++)
        {
		    if(arr[Math.abs(arr[p])] > 0)
		    {
		        arr[Math.abs(arr[p])] = -arr[Math.abs(arr[p])];
		    }
		    else
		    {
		        if(first==false)
	            {
	                res[0] = Math.abs(arr[p]);
	                first = true;
	            }
		        else
		            res[1] = Math.abs(arr[p]);
		            
		    }
        }
        return res;
    }
    
}

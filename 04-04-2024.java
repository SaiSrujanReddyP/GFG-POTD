class Solution
{
    public static long sumSubstrings(String s)
    {
        long dp[]=new long[s.length()];
        dp[0]=(int)(s.charAt(0)-'0');
        long res=0, p=1000000007;
        res=dp[0];     
        for(int i=1;i<s.length();i++)
        {   int cur_digit=(int)(s.charAt(i)-'0');  
            dp[i]=(((i+1)*(cur_digit))%p+(dp[i-1]*10)%p)%p;
            res = (res+dp[i])%p;                              
        }
        return res;
        
    }
}

class Solution {
  public:
    bool equalPartition(vector<int>& arr) {
        int sum = 0;
        for (int num : arr) sum += num; 
        if (sum % 2 != 0) return false; 

        int target = sum / 2;
        vector<bool> dp(target + 1, false);
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) { 
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
};

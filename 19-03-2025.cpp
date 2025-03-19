class Solution {
public:
    int maxProfit(vector<int>& prices, int k) {
        int n = prices.size();
        
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += (prices[i] - prices[i - 1]);
            }
            return profit;
        }

        vector<vector<int>> dp(k + 1, vector<int>(n, 0));

        for (int t = 1; t <= k; t++) {
            int maxDiff = INT_MIN;
            for (int d = 1; d < n; d++) {
                maxDiff = max(maxDiff, dp[t - 1][d - 1] - prices[d - 1]);
                dp[t][d] = max(dp[t][d - 1], prices[d] + maxDiff);
            }
        }

        return dp[k][n - 1];
    }
};

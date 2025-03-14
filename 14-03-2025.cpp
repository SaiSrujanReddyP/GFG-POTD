#include <vector>

class Solution {
public:
    int count(std::vector<int>& coins, int sum) {
        std::vector<int> dp(sum + 1, 0);
        dp[0] = 1; 

        for (int coin : coins) {
            for (int j = coin; j <= sum; ++j) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[sum];
    }
};

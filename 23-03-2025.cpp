#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countWays(string &digits) {
        const int MOD = 1e9 + 7;
        int n = digits.size();
        
        if (n == 0 || digits[0] == '0') return 0;

        vector<int> dp(n + 1, 0);
        dp[0] = 1; 
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = digits[i - 1] - '0';
            int twoDigit = stoi(digits.substr(i - 2, 2));
            if (oneDigit >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        return dp[n];
    }
};

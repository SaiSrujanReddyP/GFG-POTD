class Solution {
public:
    int countPowersInFactorial(int n, int p) {
        int cnt = 0;
        long long cur = p;
        while (cur <= n) {
            cnt += n / cur;
            cur *= p;
        }
        return cnt;
    }
    int maxKPower(int n, int k) {
        unordered_map<int,int> pf;
        for (int d = 2; d * d <= k; ++d) {
            while (k % d == 0) {
                ++pf[d];
                k /= d;
            }
        }
        if (k > 1) ++pf[k];
        
        int ans = INT_MAX;
        for (auto &pr : pf) {
            int p = pr.first, a = pr.second;
            int total = countPowersInFactorial(n, p);
            ans = min(ans, total / a);
        }
        return ans;
    }
};

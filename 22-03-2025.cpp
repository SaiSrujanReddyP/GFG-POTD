#include <vector>
using namespace std;

class Solution {
public:
    int rob_linear(const vector<int>& nums) {  // Use const reference
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    int maxValue(vector<int>& arr) {
        int n = arr.size();
        if (n == 1) return arr[0];

        return max(rob_linear(vector<int>(arr.begin(), arr.end() - 1)), 
                   rob_linear(vector<int>(arr.begin() + 1, arr.end())));
    }
};

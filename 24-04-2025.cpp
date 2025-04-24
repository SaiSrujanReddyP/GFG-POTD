class Solution {
public:
    int getSingle(vector<int>& arr) {
        int ones = 0, twos = 0;
        for (int num : arr) {
            twos |= ones & num;
            ones ^= num;
            int threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;  
    }
};

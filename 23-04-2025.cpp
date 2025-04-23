#include <vector>
#include <algorithm>
using namespace std;

class Solution {
  public:
    vector<int> singleNum(vector<int>& arr) {
        int xor_all = 0;
        for (int num : arr) {
            xor_all ^= num;
        }
        int rightmost_set_bit = xor_all & (-xor_all);
        int x = 0, y = 0;
        for (int num : arr) {
            if (num & rightmost_set_bit)
                x ^= num;  
            else
                y ^= num;  
        }
        if (x > y)
            swap(x, y);
        return {x, y};
    }
};

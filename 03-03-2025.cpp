#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        int left = 0, maxLen = 0, startIdx = 0;
        multiset<int> window;

        for (int right = 0; right < arr.size(); right++) {
            window.insert(arr[right]);

            while (*window.rbegin() - *window.begin() > x) {
                window.erase(window.find(arr[left])); 
                left++;
            }

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
        }

        return vector<int>(arr.begin() + startIdx, arr.begin() + startIdx + maxLen);
    }
};

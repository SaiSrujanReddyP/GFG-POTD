class Solution {
  public:
    int majorityElement(vector<int>& arr) {
        int candidate = -1, count = 0;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }

        if (count > arr.size() / 2) return candidate;
        return -1;
    }
};

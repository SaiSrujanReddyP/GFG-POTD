class Solution {
public:
    int maxPartitions(string &s) {
        unordered_map<char, int> lastIndex;
        int n = s.size();
        for (int i = 0; i < n; ++i) {
            lastIndex[s[i]] = i;
        }

        int partitions = 0;
        int end = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            end = max(end, lastIndex[s[i]]);
            if (i == end) {
                partitions++;
                start = i + 1;
            }
        }

        return partitions;
    }
};

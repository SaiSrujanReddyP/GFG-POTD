class Solution {
  public:
    int findSubString(string& str) {
        unordered_map<char, int> charCount;
        unordered_set<char> uniqueChars(str.begin(), str.end());
        int distinctCount = uniqueChars.size();

        int minLen = INT_MAX;
        int start = 0;
        int count = 0;
        unordered_map<char, int> windowFreq;

        for (int end = 0; end < str.length(); ++end) {
            windowFreq[str[end]]++;
            if (windowFreq[str[end]] == 1) {
                count++;
            }
            while (count == distinctCount) {
                minLen = min(minLen, end - start + 1);

                windowFreq[str[start]]--;
                if (windowFreq[str[start]] == 0) {
                    count--;
                }
                start++;
            }
        }

        return minLen;
    }
};

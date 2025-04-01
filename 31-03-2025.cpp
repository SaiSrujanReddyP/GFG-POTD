class Solution {
  public:
    int maxPartitions(string &s) {
        unordered_map<char, int> lastIndex;
      
        for (int i = 0; i < s.size(); i++) {
            lastIndex[s[i]] = i;
        }
        
        int partitions = 0;
        int maxLastIdx = 0;
        
        for (int i = 0; i < s.size(); i++) {
            maxLastIdx = max(maxLastIdx, lastIndex[s[i]]);
            
            if (i == maxLastIdx) {
                partitions++;
            }
        }
        
        return partitions;
    }
};

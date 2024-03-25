class Solution {
    void NBitBinaryUtil(String number, int extraOnes, int remainingPlaces, ArrayList<String> ans) {
        if (remainingPlaces == 0) {
            ans.add(number);
            return;
        }
        NBitBinaryUtil(number + "1", extraOnes + 1, remainingPlaces - 1, ans);
        if (extraOnes > 0) {
            NBitBinaryUtil(number + "0", extraOnes - 1, remainingPlaces - 1, ans);
        }
    }

    ArrayList<String> NBitBinary(int n) {
        ArrayList<String> ans = new ArrayList<>();
        String s = "";
        NBitBinaryUtil(s, 0, n, ans);
        return ans;
    }
}

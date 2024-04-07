class Solution {
    public int maxDotProduct(int N, int M, int[] A, int[] B) {
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = i; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + (A[j - 1] * B[i - 1]), dp[i][j - 1]);
            }
        }
        return dp[M][N];
    }}


class Solution {
    int max = 1000000000;
    boolean checkSideMine(int i, int j, int mat[][]) {
        if (i - 1 >= 0 && mat[i - 1][j] == 0) return false;
        if (i + 1 < mat.length && mat[i + 1][j] == 0) return false;
        if (j + 1 < mat[0].length && mat[i][j + 1] == 0) return false;
        if (j - 1 >= 0 && mat[i][j - 1] == 0) return false;
        return true;
    }
    int f(int i, int j, int mat[][], boolean vis[][], int dp[][]) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length ||
            vis[i][j] == true || mat[i][j] == 0)
            return max;
        if (dp[i][j] != -1) return dp[i][j];
        if (checkSideMine(i, j, mat) == false) {
            return max;
        }
        if (j == 0) return mat[i][0];
        vis[i][j] = true;
        int left = mat[i][j] + f(i, j - 1, mat, vis, dp);
        int up = mat[i][j] + f(i - 1, j, mat, vis, dp);
        int down = mat[i][j] + f(i + 1, j, mat, vis, dp);
        vis[i][j] = false;
        int min = Math.min(up, Math.min(down, left));
        return dp[i][j] = min;
    }
    public int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        int dp[][] = new int[n + 1][m + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        int min = max;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, f(i, m - 1, mat, vis, dp));
        }
        return min == max ? -1 : min;
    }
}

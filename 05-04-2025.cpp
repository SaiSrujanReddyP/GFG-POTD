class Solution {
  public:
    void dfs(int row, int col, vector<vector<char>>& grid, vector<vector<bool>>& visited, int n, int m) {
        visited[row][col] = true;

        int dRow[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dCol[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; ++i) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                grid[newRow][newCol] == 'L' && !visited[newRow][newCol]) {
                dfs(newRow, newCol, grid, visited, n, m);
            }
        }
    }

    int countIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        if (n == 0) return 0;
        int m = grid[0].size();

        vector<vector<bool>> visited(n, vector<bool>(m, false));
        int islandCount = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(i, j, grid, visited, n, m);
                    ++islandCount;
                }
            }
        }
        return islandCount;
    }
};

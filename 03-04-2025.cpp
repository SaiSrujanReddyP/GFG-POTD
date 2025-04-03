#include <vector>
#include <queue>
using namespace std;

class Solution {
  public:
    int orangesRotting(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        queue<pair<int, int>> q;
        int fresh = 0, time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.push({i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        
        vector<int> dirX = {-1, 1, 0, 0}; 
        vector<int> dirY = {0, 0, -1, 1};

        while (!q.empty()) {
            int sz = q.size();
            bool rotted = false;
            
            for (int i = 0; i < sz; i++) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();

                for (int d = 0; d < 4; d++) {
                    int newX = x + dirX[d];
                    int newY = y + dirY[d];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] == 1) {
                        mat[newX][newY] = 2; 
                        q.push({newX, newY});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if (rotted) time++; 
        }
        return (fresh == 0) ? time : -1;
    }
};

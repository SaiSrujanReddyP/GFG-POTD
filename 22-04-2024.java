class Solution {
    int minRow(int n, int m, int a[][]) {
        int i, j, mn = (int)(1e6), mni = -1;
        for (i = 0; i < n; i++) {
            int c = 0;
            for (j = 0; j < m; j++) {
                if (a[i][j] == 1) c++;
            }
            if (mn > c) {
                mn = c;
                mni = i + 1;
            }
        }
        return mni;
    }
};

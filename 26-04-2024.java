class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int i = 0, j = 0;
        int dir = 1;

        while (i < n && j < m && i >= 0 && j >= 0) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;
                switch (dir) {
                    case 1:
                        dir = 2;
                        break;
                    case 2:
                        dir = 3;
                        break;
                    case 3:
                        dir = 4;
                        break;
                    case 4:
                        dir = 1;
                        break;
                }
            }

            switch (dir) {
                case 1:
                    j++;
                    break;
                case 2:
                    i++;
                    break;
                case 3:
                    j--;
                    break;
                case 4:
                    i--;
                    break;
            }
        }

        switch (dir) {
            case 1:
                j--;
                break;
            case 2:
                i--;
                break;
            case 3:
                j++;
                break;
            case 4:
                i++;
                break;
        }

        return new int[] {i, j};
    }
}

class Solution {
    static int M = 1000000007;
    static int firstElement(int n) {
        int a = 0, b = 1, c, i;
        if (n == 0) return a;
        for (i = 2; i <= n; i++) {
            c = (a + b) % M;
            a = b % M;
            b = c % M;
        }
        return b % M;
    }
}

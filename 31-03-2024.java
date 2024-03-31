class Solution {
    static int findMaxForN(Node root, int n) {
        if (root == null) return -1;
        if (root.key == n) return n;
        else if (root.key < n) {
            int k = findMaxForN(root.right, n);
            if (k == -1)
                return root.key;
            else
                return k;
        }
        else if (root.key > n)
            return findMaxForN(root.left, n);
        return -1;
    }
}

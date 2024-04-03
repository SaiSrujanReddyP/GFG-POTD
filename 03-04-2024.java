class Solution {
    Node LCA(Node root, int x, int y) {
        if (root == null) return null;
        if (x < root.data && y < root.data) return LCA(root.left, x, y);
        if (x > root.data && y > root.data) return LCA(root.right, x, y);
        return root;
    }
    void pathToNode(Node root, Node node, ArrayList<Integer> path) {
        path.add(root.data);
        if (root.data == node.data)
            return;
        else if (node.data > root.data)
            pathToNode(root.right, node, path);
        else
            pathToNode(root.left, node, path);
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        Node lca = LCA(root, x, y);
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathToNode(root, lca, path);
        Collections.reverse(path); 
        if (path.size() < k) return -1;
        return path.get(k - 1); 
    }
}

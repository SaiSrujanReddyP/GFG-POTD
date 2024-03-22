class Tree {

    public static void diagonalSumUtil(Node root, int diagonal, Map<Integer, Integer> map)
    {
        if (root == null) {
            return;
        }
        map.put(diagonal, map.getOrDefault(diagonal, 0) + root.data);
        diagonalSumUtil(root.left, diagonal + 1, map);
        diagonalSumUtil(root.right, diagonal, map);
    }
    public static ArrayList <Integer> diagonalSum(Node root)
    {   ArrayList <Integer> res = new ArrayList <Integer> (0);
        Map<Integer, Integer> map = new HashMap<>();
        diagonalSumUtil(root, 0, map);
        for (Integer key : map.values()) {
            res.add(key);
        }
        return res;
    }
};

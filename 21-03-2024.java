class GFG
{
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> q = new LinkedList<>();
        q.add(root);
        res.add(root.data);
        int level = 1;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp;
                if (level % 2 == 0)
                    temp = q.removeLast();
                else
                    temp = q.removeFirst();

                if (level % 2 != 0) {
                    if (temp.right != null) {
                        q.addLast(temp.right);
                        res.add(temp.right.data);
                    }
                    if (temp.left != null) {
                        q.addLast(temp.left);
                        res.add(temp.left.data);
                    }
                } else {
                    if (temp.left != null) {
                        q.addFirst(temp.left);
                        res.add(temp.left.data);
                    }
                    if (temp.right != null) {
                        q.addFirst(temp.right);
                        res.add(temp.right.data);
                    }
                }
            }
            level++;
        }
        return res;
	}
	
}

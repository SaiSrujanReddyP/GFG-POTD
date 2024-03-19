class Solution {
    int ans;
    private int root(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    private int Union(int a, int b, int[] parent, int[] sz) {
        int ra = root(a, parent);
        int rb = root(b, parent);
        if (ra == rb)
            return sz[ra] * sz[ra];
        if (sz[ra] < sz[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;
            temp = a;
            a = b;
            b = temp;
        }
        ans += sz[ra] * sz[rb];
        parent[rb] = ra;
        sz[ra] += sz[rb];
        return ans;
    }
    ArrayList<Integer> maximumWeight(int n, int[][] edges, int q, int[] queries) {
        ans = 0;
        int[] parent = new int[n + 1];
        int[] sz = new int[n + 1];
        Arrays.fill(sz, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        NavigableMap<Integer, Integer> mp = new TreeMap<>();
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            mp.put(c, Union(a, b, parent, sz));
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int query : queries) {
            Map.Entry<Integer, Integer> entry = mp.floorEntry(query);
            if (entry == null)
                res.add(0); 
            else
                res.add(entry.getValue()); 
        }
        return res;
    }
}

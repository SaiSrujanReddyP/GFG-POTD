class Solution {
    class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    } 
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int arr[] : edges) {
            int u = arr[0], v = arr[1], w = arr[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        int min = Integer.MAX_VALUE, city = -1;
        for (int src = 0; src < n; src++) {
            PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b)->{ return a.weight - b.weight; });
            boolean[] vis = new boolean[n];
            int[] arr = new int[n];
            Arrays.fill(arr, Integer.MAX_VALUE);
            arr[src] = 0;
            int count = 0;
            pq.add(new Pair(src, 0));
            while (pq.size() > 0) {
                Pair p = pq.remove();
                int node = p.node, weight = p.weight;
                if (vis[node]) continue;
                vis[node] = true;
                if (weight <= distanceThreshold) count++;
                for (Pair ele : adj.get(node)) {
                    if (arr[node] + ele.weight < arr[ele.node]) {
                        arr[ele.node] = arr[node] + ele.weight;
                        pq.add(new Pair(ele.node, arr[ele.node]));
                    }
                }
            }
            if (count <= min) {
                min = count;
                city = src;
            }
        }
        return city;
    }
}

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src) {
        vector<pair<int, int>> adj[V];
        for (auto &e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].push_back(make_pair(v, w));
            adj[v].push_back(make_pair(u, w));  
        }

        vector<int> dist(V, INT_MAX);
        dist[src] = 0;

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push(make_pair(0, src));

        while (!pq.empty()) {
            pair<int, int> current = pq.top();
            pq.pop();
            int d = current.first;
            int u = current.second;

            if (d > dist[u]) continue;

            for (int i = 0; i < adj[u].size(); ++i) {
                int v = adj[u][i].first;
                int w = adj[u][i].second;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.push(make_pair(dist[v], v));
                }
            }
        }

        return dist;
    }
};

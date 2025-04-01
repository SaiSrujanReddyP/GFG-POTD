#include <vector>
using namespace std;

class Solution {
public:
    void dfsHelper(int node, vector<vector<int>>& adj, vector<bool>& visited, vector<int>& result) {
        visited[node] = true;
        result.push_back(node);
        
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
    
    vector<int> dfs(vector<vector<int>>& adj) {
        vector<int> result;
        vector<bool> visited(adj.size(), false);
        
        dfsHelper(0, adj, visited, result);
        
        return result;
    }
};

class Solution {
  public:
    pair<int, int> solve(Node* root) {
        if (!root) {
            return {0, 0};
        }
        pair<int, int> left = solve(root->left);
        pair<int, int> right = solve(root->right);
        int include = root->data + left.second + right.second;
        int exclude = max(left.first, left.second) + max(right.first, right.second);
        
        return {include, exclude};
    }
    int getMaxSum(Node *root) {
        pair<int, int> res = solve(root);
        return max(res.first, res.second);
    }
};

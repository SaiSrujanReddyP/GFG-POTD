class Solution {
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            int listSize = adj.get(i).size();
            if (listSize % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}

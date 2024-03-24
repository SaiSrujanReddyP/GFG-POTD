class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> St, int X) {
        recur(St, X);
        return St;
    }

    public void recur(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int p = st.pop();
        recur(st, x);
        st.push(p);
    }
}

class Solution{
    ArrayList<Integer>  findMissing(int a[], int b[],  int N, int M){ 
        Set<Integer> s = new HashSet<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) 
            s.add(b[i]); 
        for (int i = 0; i < N; i++) 
            if (!s.contains(a[i])) 
                ans.add(a[i]);
        return ans;
    } 

};

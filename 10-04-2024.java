class Solution{
    static int findSingle(int n, int arr[]){
        int ans = 0;
        for(int i = 0;i < n;i++){
            ans ^= arr[i];
        }
        return ans;
    }
}

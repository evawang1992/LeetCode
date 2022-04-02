class Solution {
    public int kthFactor(int n, int k) {
        if(k > n) return -1;
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                if(--k == 0) {
                    // System.out.println(k);
                    return i;
                }
            }
        }
        return -1;
    }
    
    
}
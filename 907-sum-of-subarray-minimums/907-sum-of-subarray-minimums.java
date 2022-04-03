
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, j, k;
        long res = 0;
        
        Stack<Integer> s = new Stack<>();
        int M = (int)1e9 + 7;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > (i == n ? Integer.MIN_VALUE : arr[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res = (res+(long)arr[j] * (i - j) * (j - k))%M;

            }
            s.push(i);
        }
        return (int)res;
    }
}
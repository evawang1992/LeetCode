class Solution {
    public int firstUniqChar(String s) {
        int [] arr = new int [26];
        Arrays.fill(arr,-1);
        for(int i = 0; i< s.length();i++){
        int ind = s.charAt(i)-'a';
            if(arr[ind] >=0) arr[ind]=-2;
            else if(arr[ind]==-1) arr[ind]=i;
        }
        int min = s.length();
        for(int i = 0; i< arr.length; i++){
            if(arr[i] >= 0)min = Math.min(min, arr[i]);
        }
        return min==s.length()?-1:min;
    }
}
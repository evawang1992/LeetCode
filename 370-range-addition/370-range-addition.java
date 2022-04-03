class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
int[] res = new int[length];
        if(updates == null || updates.length < 1) return res;
        for(int[] i : updates){
            res[i[0]] += i[2];
            if(i[1] < length-1)res[i[1]+1]-=i[2];
        }
        int sum = 0;
        for(int i = 0; i < length; i++){
            res[i]+= sum;
            sum = res[i];
        }
        return res;
    }
}
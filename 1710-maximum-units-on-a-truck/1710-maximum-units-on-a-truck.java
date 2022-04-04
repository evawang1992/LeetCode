class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (int[] a, int[] b) -> b[1]-a[1]);
        int ind = 0, res = 0;
        while(truckSize > 0 && ind < boxTypes.length){
            int[] b = boxTypes[ind];
            if(b[0] > truckSize){
                return res+truckSize* b[1];
            }
            truckSize-=b[0];
            res+=b[0]*b[1];
            ind++;
        }
        return res;
    }
}
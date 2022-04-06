class Solution {
    public String[] less_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        public String[] tens = {"","Ten", "Twenty","Thirty", "Forty","Fifty", "Sixty","Seventy","Eighty","Ninety", "Hundred"};
        public String[] thousands = {"","Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        int i = 0;
        String res = "";
        while(num > 0){
            if(num %1000 > 0){
                res = getString(num%1000) + thousands[i] + " "+ res;
                
            }
            num /=1000;
            i++;
        }
        return res.trim();
    }
    String getString(int num){
        String s = "";
        while(num > 0){
            if(num >= 100){
            s+= less_20[num/100]+" Hundred ";
            num = num%100;
        }
        else if(num >= 20){
            s+= tens[num /10]+" ";
            num = num%10;
        }
            else {s+=less_20[num]+" ";
            num = num/20;
                 }
        }
        return s;
        
    }
}
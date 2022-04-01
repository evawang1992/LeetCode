class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if(searchWord == null || searchWord.length() == 0) return res;
        TreeMap<String,Integer> map = new TreeMap<>();
        List<String> productList = Arrays.asList(products);
        Collections.sort(productList);
        for(int i = 0; i < products.length; i++){
            map.put(products[i], i);
            
        }
        String k = "";
        for(char c : searchWord.toCharArray()){
            k+=c;
            String ceiling = map.ceilingKey(k);
            String floor = map.floorKey(k+"~");
            if(ceiling == null || floor == null) break;
            int cv = map.get(ceiling);
            int f = map.get(floor);
            res.add(productList.subList(cv, Math.min(cv+3, f+1)));
        }
        while(res.size() != searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
}
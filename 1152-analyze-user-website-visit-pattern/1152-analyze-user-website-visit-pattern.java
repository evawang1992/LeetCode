class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Set<String>>  map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int maxcount = 0;
        String word = "";
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < username.length; i++){
            list.add(new String[]{username[i], timestamp[i]+"", website[i]});
        }
        list.sort((String[] a, String[] b)-> (!a[0].equals(b[0])?a[0].compareTo(b[0]):Integer.valueOf(a[1])-Integer.valueOf(b[1])));
        
        // for(String[] ss : list){
        //     System.out.println(ss[0]+" "+ ss[1]+" "+ ss[2]);
        // }
        if(username == null || username.length == 0 || username.length != website.length) return res;
        for(int i = 0; i < username.length; i++){
            for(int j = i+1; j < username.length; j++){
                for(int h = j+1; h < username.length; h++){
                    if(!list.get(i)[0].equals(list.get(h)[0])) break;
                    String s = list.get(i)[2]+" "+list.get(j)[2] + " "+list.get(h)[2];
                    map.computeIfAbsent(s, k->new HashSet<>()).add(list.get(i)[0]);
                    Set<String> set = map.get(s);
                    if(set.size() > maxcount || (set.size() == maxcount && s.compareTo(word) < 0)) {
                        maxcount = set.size();
                        word = s;
                    }
                    
                }
            }
        }
        if(word.length() == 0) return res;
        String[] wordlist = word.split(" ");
        res = Arrays.asList(wordlist);
        return res;
    }
}
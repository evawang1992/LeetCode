class Trie {
class TrieNode{
    TrieNode[] children = new TrieNode[26];
        String word = null;
}
    public Trie() {
        
    }
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode travsor = root;
        for(char c : word.toCharArray()){
            if(travsor.children[c-'a']==null) travsor.children[c-'a'] = new TrieNode();
            travsor = travsor.children[c-'a'];
        }
        travsor.word = word;
    }
    
    public boolean search(String word) {
        TrieNode travsor = root;
        for(char c : word.toCharArray()){
            if(travsor.children[c-'a']==null) return false;
            travsor = travsor.children[c-'a'];
        }
        return travsor.word != null && travsor.word.equals(word);
    }
    
    public boolean startsWith(String prefix) {
        TrieNode travsor = root;
        for(char c : prefix.toCharArray()){
            if(travsor.children[c-'a']==null) return false;
            travsor = travsor.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
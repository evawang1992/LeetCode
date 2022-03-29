class Trie {
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word = null;
}
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if(word.isEmpty()) return;
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null) n.children[c-'a'] = new TrieNode();
            n = n.children[c-'a'];
        }
        n.word = word;
    }
    
    public boolean search(String word) {
        if(word == null) return false;
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null) return false;
            n = n.children[c-'a'];
        }
        return n.word != null && n.word.equals(word);
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null) return false;
        TrieNode n = root;
        for(char c : prefix.toCharArray()){
            if(n.children[c-'a'] == null) return false;
            n = n.children[c-'a'];
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
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        if (node == null) return false;
        if (word.isEmpty()) return node.isEndOfWord;
        
        char c = word.charAt(0);
        if (c == '.') {
            // Check all possible children nodes
            for (TrieNode child : node.children.values()) {
                if (searchInNode(word.substring(1), child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Check the specific child node
            TrieNode child = node.children.get(c);
            return searchInNode(word.substring(1), child);
        }
    }
}

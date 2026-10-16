class WordDictionary {
    private final TrieNode root;

    //trie Node class:
    private static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        //loop over each character of the word:
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            //if character doesn't exist, create a new node:
            current.children.putIfAbsent(ch, new TrieNode());

            //move to the next node:
            current = current.children.get(ch);
        }

        //mark the last character as the end of a word:
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode current) {
        //base case: if all characters are processed, check whether a word ends here:
        if (index == word.length()) {
            return current.isEndOfWord;
        }

        char ch = word.charAt(index);

        //if wildcard, explore all possible children:
        if (ch == '.') {
            for (TrieNode child : current.children.values()) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        //otherwise, follow the matching character:
        TrieNode next = current.children.get(ch);

        if (next == null) {
            return false;
        }

        return dfs(word, index + 1, next);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
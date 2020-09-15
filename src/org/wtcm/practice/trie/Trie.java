package org.wtcm.practice.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String keyword, Integer cid) {
        TrieNode current = root;

        for (int i = 0; i < keyword.length(); i++)
            current = current.getChildren().computeIfAbsent(keyword.charAt(i), c -> new TrieNode());

        current.setEndOfWord(true);
//        current.setContentKey(cid);
    }

    public boolean delete(String keyword) {
        return delete(root, keyword, 0);
    }

    public boolean containsNode(String query) {
        TrieNode current = root;

        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null)
                return false;
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean delete(TrieNode current, String query, int index) {
        if (index == query.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = query.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, query, index+1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}

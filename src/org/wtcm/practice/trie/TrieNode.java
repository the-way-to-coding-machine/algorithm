package org.wtcm.practice.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    private Integer contentKey;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public Integer getContentKey() {
        return contentKey;
    }

    public void setContentKey(Integer contentKey) {
        this.contentKey = contentKey;
    }
}

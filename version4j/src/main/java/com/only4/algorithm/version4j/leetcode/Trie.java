package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
class Trie {

    private static final int ALPHABET_SIZE = 26;
    private final TrieNode root;

    /**
     * Trie节点定义
     */
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[ALPHABET_SIZE];
            this.isEndOfWord = false;
        }
    }

    /**
     * 初始化Trie对象
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 向Trie中插入单词
     *
     * @param word 要插入的单词
     */
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    /**
     * 搜索Trie中是否存在完整的单词
     *
     * @param word 要搜索的单词
     * @return 单词是否存在
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    /**
     * 检查是否存在以给定前缀开头的单词
     *
     * @param prefix 要检查的前缀
     * @return 是否存在该前缀
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 搜索前缀对应的节点
     *
     * @param prefix 前缀字符串
     * @return 对应的节点，如果不存在返回null
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }

        return current;
    }
}

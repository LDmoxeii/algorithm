package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
class Trie {

    private Node root;

    class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node pre = root;
        Node current;
        for (int i = 0; i < chars.length; i++) {
            current = pre.children[chars[i] - 'a'];
            if (current == null) current = new Node();
            if (i == chars.length - 1) current.isEnd = true;
            pre.children[chars[i] - 'a'] = current;
            pre = current;
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            node = node.children[chars[i] - 'a'];
            if (node == null) return false;
            if (i == chars.length - 1) return node.isEnd;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;
        for (char aChar : chars) {
            node = node.children[aChar - 'a'];
            if (node == null) return false;
        }
        return true;
    }
}

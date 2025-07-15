package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Trie算法的单元测试
 */
public class TrieTest {

    private Trie trie;

    @BeforeEach
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void testInsertAndSearch() {
        // 插入单词并测试搜索
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
    }

    @Test
    public void testStartsWith() {
        // 测试前缀搜索
        trie.insert("apple");
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("apple"));
        assertFalse(trie.startsWith("banana"));
    }

    @Test
    public void testMultipleWords() {
        // 测试多个单词
        String[] words = {"hello", "world", "help", "height", "hello"};
        for (String word : words) {
            trie.insert(word);
        }

        assertTrue(trie.search("hello"));
        assertTrue(trie.search("world"));
        assertTrue(trie.search("help"));
        assertTrue(trie.search("height"));
        assertFalse(trie.search("hell"));
        assertFalse(trie.search("heights"));

        assertTrue(trie.startsWith("h"));
        assertTrue(trie.startsWith("he"));
        assertTrue(trie.startsWith("hel"));
        assertTrue(trie.startsWith("help"));
        assertTrue(trie.startsWith("w"));
        assertTrue(trie.startsWith("wo"));
        assertFalse(trie.startsWith("a"));
    }

    @Test
    public void testSpecialCases() {
        // 测试特殊情况
        trie.insert("a");
        assertTrue(trie.search("a"));
        assertTrue(trie.startsWith("a"));

        trie.insert("ab");
        assertTrue(trie.search("ab"));

        // 测试长单词
        StringBuilder longWord = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longWord.append("a");
        }
        trie.insert(longWord.toString());
        assertTrue(trie.search(longWord.toString()));
        assertTrue(trie.startsWith(longWord.substring(0, 500)));
    }
}

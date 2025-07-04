/**
 * [208. 实现 Trie (前缀树)](https://leetcode.com/problems/implement-trie-prefix-tree/)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 * - Trie() 初始化前缀树对象。
 * - void insert(String word) 向前缀树中插入字符串 word 。
 * - boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * - boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 解题思路：
 * 使用树形结构实现 Trie，每个节点包含一个字符映射表（Map）和一个标志位表示是否是单词结尾。
 * 插入操作：遍历单词的每个字符，如果当前节点的子节点中没有该字符，则创建一个新节点；然后移动到该字符对应的子节点。
 * 搜索操作：遍历单词的每个字符，如果当前节点的子节点中没有该字符，则返回 false；否则移动到该字符对应的子节点。
 * 前缀搜索：与搜索操作类似，但不需要检查最后一个节点是否为单词结尾。
 *
 * 时间复杂度：
 * - 插入操作：O(m)，其中 m 是单词的长度
 * - 搜索操作：O(m)，其中 m 是单词的长度
 * - 前缀搜索：O(m)，其中 m 是前缀的长度
 *
 * 空间复杂度：O(T)，其中 T 是所有插入单词的字符总数
 */
package com.only4.algorithm.leetcode

class Trie {
    private val root = Node()

    private data class Node(
        val children: MutableMap<Char, Node> = mutableMapOf(),
        var isTerminal: Boolean = false
    )

    /**
     * 向 Trie 中插入一个单词
     *
     * @param word 要插入的单词
     */
    fun insert(word: String) {
        word.fold(root) { node, char ->
            node.children.getOrPut(char) { Node() }
        }.isTerminal = true
    }

    /**
     * 搜索 Trie 中是否存在完全匹配的单词
     *
     * @param word 要搜索的单词
     * @return 如果单词存在于 Trie 中则返回 true，否则返回 false
     */
    fun search(word: String): Boolean = traverse(word)?.isTerminal == true

    /**
     * 判断 Trie 中是否有以给定前缀开头的单词
     *
     * @param prefix 要搜索的前缀
     * @return 如果 Trie 中存在以该前缀开头的单词则返回 true，否则返回 false
     */
    fun startsWith(prefix: String): Boolean = traverse(prefix) != null

    /**
     * 遍历 Trie 查找给定字符串对应的节点
     *
     * @param input 要遍历的字符串
     * @return 如果找到对应的节点则返回该节点，否则返回 null
     */
    private fun traverse(input: String): Node? = input.fold(root) { node, char ->
        node.children[char] ?: return null
    }
}

/**
 * 示例用例：
 *
 * 示例 1:
 * 输入：
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出：
 * [null, null, true, false, true, null, true]
 *
 * 解释：
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 示例 2:
 * 假设我们插入了单词 "hello"、"world"、"help"、"hell"
 *
 * 1. 搜索 "hello" 将返回 true，因为已经插入了这个单词
 * 2. 搜索 "hel" 将返回 false，因为没有插入这个单词（尽管它是其他单词的前缀）
 * 3. 调用 startsWith("hel") 将返回 true，因为有单词以 "hel" 为前缀
 * 4. 搜索 "world" 将返回 true，因为已经插入了这个单词
 * 5. 搜索 "worl" 将返回 false，因为没有插入这个单词
 * 6. 调用 startsWith("worl") 将返回 true，因为有单词以 "worl" 为前缀
 *
 * Trie 数据结构的应用场景：
 * 1. 自动补全功能（如搜索引擎、输入法）
 * 2. 拼写检查器
 * 3. IP 路由（最长前缀匹配）
 * 4. 字典中的单词查找
 * 5. 字符串的前缀统计
 */

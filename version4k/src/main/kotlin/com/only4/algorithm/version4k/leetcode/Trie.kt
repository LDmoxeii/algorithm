package com.only4.algorithm.version4k.leetcode

class Trie {
    private val root = TrieNode()

    companion object {
        private const val ALPHABET_SIZE = 26
    }

    /**
     * Trie节点定义
     */
    private data class TrieNode(
        val children: Array<TrieNode?> = arrayOfNulls(ALPHABET_SIZE),
        var isEndOfWord: Boolean = false,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as TrieNode
            if (!children.contentEquals(other.children)) return false
            if (isEndOfWord != other.isEndOfWord) return false
            return true
        }

        override fun hashCode(): Int {
            var result = children.contentHashCode()
            result = 31 * result + isEndOfWord.hashCode()
            return result
        }
    }

    /**
     * 向Trie中插入单词
     *
     * @param word 要插入的单词
     */
    fun insert(word: String) {
        word.fold(root) { current, char ->
            val index = char - 'a'
            if (current.children[index] == null) {
                current.children[index] = TrieNode()
            }
            current.children[index]!!
        }.isEndOfWord = true
    }

    /**
     * 搜索Trie中是否存在完整的单词
     *
     * @param word 要搜索的单词
     * @return 单词是否存在
     */
    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node?.isEndOfWord == true
    }

    /**
     * 检查是否存在以给定前缀开头的单词
     *
     * @param prefix 要检查的前缀
     * @return 是否存在该前缀
     */
    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    /**
     * 搜索前缀对应的节点
     *
     * @param prefix 前缀字符串
     * @return 对应的节点，如果不存在返回null
     */
    private fun searchPrefix(prefix: String): TrieNode? {
        return prefix.fold(root) { current, char ->
            val index = char - 'a'
            current.children[index] ?: return null
        }
    }
}

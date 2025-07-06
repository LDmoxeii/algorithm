package com.only4.algorithm.leetcode

/**
 * [5. 最长回文子串](https://leetcode.com/problems/longest-palindromic-substring/)
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例:
 * - 输入: s = "babad"
 * - 输出: "bab"
 * - 解释: "aba" 也是一个有效答案。
 *
 * - 输入: s = "cbbd"
 * - 输出: "bb"
 */

/**
 * 使用动态规划方法解决最长回文子串问题
 *
 * 解题思路:
 * 定义dp[i][j]表示子串s[i..j]是否为回文串。
 * 状态转移方程:
 * 1. 当i==j时，dp[i][j] = true（单个字符一定是回文）
 * 2. 当j-i==1时，dp[i][j] = (s[i]==s[j])（两个字符，相等才是回文）
 * 3. 当j-i>1时，dp[i][j] = (s[i]==s[j] && dp[i+1][j-1])（首尾字符相等，且中间子串是回文）
 *
 * 时间复杂度: O(n²)，其中n是字符串长度
 * 空间复杂度: O(n²)，需要一个n*n的dp数组
 *
 * @param s 输入字符串
 * @return 最长的回文子串
 */
fun longestPalindromeDP(s: String): String {
    // 处理空字符串和长度为1的字符串
    val length = s.length
    if (length < 2) return s

    // 初始化变量，记录最长回文子串的起始位置和长度
    var startIndex = 0
    var maxLength = 1

    // 创建dp数组，isPalindrome[i][j]表示子串s[i...j]是否为回文串
    val isPalindrome = Array(length) { BooleanArray(length) }

    // 单个字符都是回文
    for (i in 0 until length) {
        isPalindrome[i][i] = true
    }

    // 检查长度为2的子串
    for (i in 0 until length - 1) {
        if (s[i] == s[i + 1]) {
            isPalindrome[i][i + 1] = true
            startIndex = i
            maxLength = 2
        }
    }

    // 检查长度大于2的子串
    // 按照子串长度从3到n遍历
    for (substrLength in 3..length) {
        // 子串的起始位置
        for (startPos in 0..length - substrLength) {
            // 子串的结束位置
            val endPos = startPos + substrLength - 1

            // 状态转移：首尾字符相等且中间子串是回文
            if (s[startPos] == s[endPos] && isPalindrome[startPos + 1][endPos - 1]) {
                isPalindrome[startPos][endPos] = true

                // 更新最长回文子串信息
                if (substrLength > maxLength) {
                    startIndex = startPos
                    maxLength = substrLength
                }
            }
        }
    }

    // 返回最长回文子串
    return s.substring(startIndex, startIndex + maxLength)
}

/**
 * 使用中心扩展法解决最长回文子串问题
 *
 * 解题思路:
 * 回文串一定是对称的，所以可以每次选择一个中心，进行左右扩展，判断左右字符是否相等。
 * 由于回文串的长度可能是奇数也可能是偶数，所以需要分别处理两种情况：
 * 1. 回文串长度为奇数时，中心是一个字符
 * 2. 回文串长度为偶数时，中心是两个字符
 *
 * 时间复杂度: O(n²)，其中n是字符串长度
 * 空间复杂度: O(1)，只需要常数空间存储变量
 *
 * @param s 输入字符串
 * @return 最长的回文子串
 */
fun longestPalindromeExpand(s: String): String {
    var longestPalindrome = ""

    /**
     * 从中心向两边扩展，寻找回文子串
     *
     * @param s 原始字符串
     * @param leftStart 左侧起始位置
     * @param rightStart 右侧起始位置
     * @return 以leftStart和rightStart为中心的最长回文子串
     */
    fun expandAroundCenter(s: String, leftStart: Int, rightStart: Int): String {
        var left = leftStart
        var right = rightStart

        // 向两边扩展，直到不满足回文条件
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }

        // 返回找到的回文子串
        // 注意：left和right已经各自多走了一步，所以要left+1和right
        return s.substring(left + 1, right)
    }

    // 遍历字符串的每个位置，以其为中心寻找回文子串
    s.forEachIndexed { index, _ ->
        // 处理奇数长度的回文串，以当前字符为中心
        val oddLengthPalindrome = expandAroundCenter(s, index, index)

        // 处理偶数长度的回文串，以当前字符和下一个字符之间的空隙为中心
        val evenLengthPalindrome = expandAroundCenter(s, index, index + 1)

        // 更新最长回文子串
        if (oddLengthPalindrome.length > longestPalindrome.length) {
            longestPalindrome = oddLengthPalindrome
        }
        if (evenLengthPalindrome.length > longestPalindrome.length) {
            longestPalindrome = evenLengthPalindrome
        }
    }

    return longestPalindrome
}

/**
 * 使用Manacher算法解决最长回文子串问题
 *
 * 解题思路:
 * Manacher算法是一种线性时间复杂度O(n)的算法，专门用于查找最长回文子串。
 *
 * 算法步骤:
 * 1. 预处理字符串，在每个字符之间插入特殊字符(如'#')，使得所有回文子串的长度都变为奇数，统一处理逻辑
 * 2. 使用数组radiusArray记录以每个位置为中心的回文半径
 * 3. 利用已经计算过的回文信息，避免重复计算，通过"镜像"原理优化
 * 4. 维护当前已找到的回文子串的右边界和中心位置
 *
 * 时间复杂度: O(n)，其中n是字符串长度
 * 空间复杂度: O(n)，需要O(n)的辅助数组
 *
 * @param s 输入字符串
 * @return 最长的回文子串
 */
fun longestPalindromeManacher(s: String): String {
    // 处理空字符串
    if (s.isEmpty()) return ""

    // 预处理字符串，在字符间插入特殊字符'#'
    // 例如："abc" -> "#a#b#c#"
    val processedString = buildString {
        append('#')
        for (c in s) {
            append(c)
            append('#')
        }
    }

    val processedLength = processedString.length

    // radiusArray[i]表示以i为中心的最长回文子串的半径
    val radiusArray = IntArray(processedLength)

    // 维护已找到的回文子串的右边界和中心
    var centerPosition = 0      // 当前已找到的回文子串的中心位置
    var rightBoundary = 0       // 当前已找到的回文子串的右边界

    var maxRadius = 0           // 最长回文子串的半径
    var maxCenterPosition = 0   // 最长回文子串的中心位置

    for (currentPos in 0 until processedLength) {
        // 利用对称性，如果currentPos在当前回文子串的右边界内，可以利用镜像位置的信息
        if (currentPos < rightBoundary) {
            // currentPos关于centerPosition的镜像位置
            val mirrorPos = 2 * centerPosition - currentPos

            // 利用对称性，但不能超过右边界
            radiusArray[currentPos] = minOf(rightBoundary - currentPos, radiusArray[mirrorPos])
        }

        // 以currentPos为中心，尝试扩展回文
        var leftPos = currentPos - (1 + radiusArray[currentPos])
        var rightPos = currentPos + (1 + radiusArray[currentPos])

        // 扩展回文边界，直到不满足回文条件或超出字符串范围
        while (leftPos >= 0 && rightPos < processedLength &&
            processedString[leftPos] == processedString[rightPos]
        ) {
            radiusArray[currentPos]++
            leftPos--
            rightPos++
        }

        // 更新右边界和中心
        if (currentPos + radiusArray[currentPos] > rightBoundary) {
            centerPosition = currentPos
            rightBoundary = currentPos + radiusArray[currentPos]
        }

        // 更新最长回文信息
        if (radiusArray[currentPos] > maxRadius) {
            maxRadius = radiusArray[currentPos]
            maxCenterPosition = currentPos
        }
    }

    // 计算原始字符串中的起始位置
    // 在处理后的字符串中，回文中心是maxCenterPosition，半径是maxRadius
    // 需要将其映射回原始字符串的位置
    val originalStart = (maxCenterPosition - maxRadius) / 2

    // 返回最长回文子串
    return s.substring(originalStart, originalStart + maxRadius)
}

/**
 * 最长回文子串问题的默认解法 (使用Manacher算法，因为它是最优的)
 *
 * @param s 输入字符串
 * @return 最长的回文子串
 */
fun longestPalindrome(s: String): String {
    return longestPalindromeManacher(s)
}

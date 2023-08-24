package leetcode_solutions

fun main() {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
}

/**
 * Explanation => https://www.youtube.com/watch?v=E-tmN1OM9aA&t=398s
 * */
fun longestPalindrome(s: String): String {
    var max = ""

    for (i in s.indices) {
        // odd palindrome
        var result = s.getPalindrome(i, i)
        if (max.length < result.length) {
            max = result
        }

        // even palindrome
        result = s.getPalindrome(i, i + 1)
        if (max.length < result.length) {
            max = result
        }
    }

    return max
}

@Suppress("NAME_SHADOWING")
fun String.getPalindrome(left: Int, right: Int): String {
    var left = left
    var right = right
    while (left >= 0 && right < length && this[left] == this[right]) {
        left -= 1
        right += 1
    }

    return substring(left + 1, right)
}
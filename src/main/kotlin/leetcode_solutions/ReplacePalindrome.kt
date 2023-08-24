package leetcode_solutions

/**
 * Create a palindrome from the given string replacing '?' character
 * */
fun solution(S: String): String {
    // Implement your solution here
    val charArray = S.toCharArray()

    val length = charArray.size
    for (i in charArray.indices) {

        // check if palindrome is possible
        if (charArray[i] != '?' 
        && charArray[length - i - 1] != '?' 
        && charArray[i] != charArray[length - i - 1]) {
            return "NO"
        }
        
        // replace first and last with identical character
        // or with 'a' in case if both indexes has '?' character
        if (charArray[i] == '?') {
            if (charArray[length - i - 1] != '?') {
                charArray[i] = charArray[length - i - 1]
            } else {
                charArray[i] = 'a'
                charArray[length - i - 1] = 'a'
            }
        }
    }

    return String(charArray)
}

fun main() {
    println(solution("?ab??a"))
}
package leetcode_solutions

/**
 * Find the minimum cost to replace duplicate characters when the string is given
 * and the cost of replacing each character in an array
 * */
fun solution(S: String, C: IntArray): Int {
    var totalCost = 0
    for (i in 0 until S.length - 1) {
        if (S[i] != S[i + 1]) continue
        if (C[i] > C[i + 1]) {
            // swap the values
            C[i] = C[i + 1].also { C[i + 1] = C[i] }
        }
        totalCost += C[i]
    }

    return totalCost
}

fun main() {
    println(solution("aabbcc", intArrayOf(1, 2, 1, 2, 1, 2)))
}

/*
* Example test:   ('aabbcc', [1, 2, 1, 2, 1, 2])
OK

Example test:   ('aaaa', [3, 4, 5, 6])
OK

Example test:   ('ababa', [10, 5, 10, 5, 10])
OK
* */
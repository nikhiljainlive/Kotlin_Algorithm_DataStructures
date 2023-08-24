package leetcode_solutions

/**
 * Find the number of steps for next highest temperature for i th temperature in an array
 * */
fun main() {
    println(getWarmerTemperatureDays(arrayOf(73, 74, 75, 71, 69, 72, 76, 73)).joinToString())
}

/** O(n^2) Brute force */
fun getWarmerTemperatureDays(temperatures: ArrayList<Int>): ArrayList<Int> {
    val list = arrayListOf<Int>()
    for (i in 0 until temperatures.size) {
        var count = 0
        for (j in i until temperatures.lastIndex) {
            if (temperatures[i] < temperatures[j]) {
                count = j - i
                break
            }
        }
        list.add(count)
    }
    return list
}

/**
 * O(n) time complexity
 *
 * Dry run:
 *
 * temperatures => [73, 74, 75, 71, 69, 72, 76, 73]
 * result => [0, 0, 0, 0, 0, 0, 0, 0]
 *
 * until stack is not empty and temperature index at i > stack top
 *
 *  i = 0 | 73
 *  stack => empty
 *  stack => 0
 *
 *  i = 1 | 74
 *  stack => 0 (removed) 1 (added)
 *  result[0] = 1 - 0  (1)
 *  result => [1, 0, 0, 0, 0, 0, 0, 0]
 *
 *  i = 2 | 75
 *  stack => 1 (removed) 2 (added)
 *  result[1] = 2 - 1
 *  result => [1, 1, 0, 0, 0, 0, 0, 0]
 *
 *  i = 3 | 71
 *  stack => 2 => 3 (added)
 *
 *  i = 4 | 69
 *  stack => 2 => 3 => 4 (added)
 *
 *  i = 5 | 72
 *
 *  stack => 2 => 3 => 4 (removed)
 *  result[4] = 5 - 4 = 1
 *  result => [1, 1, 0, 0, 1, 0, 0, 0]
 *
 *  stack => 2 => 3 (removed)
 *  result[3] = 5 - 3 = 2
 *  result => [1, 1, 0, 2, 1, 0, 0, 0]
 *
 *  stack => 2 => 5 (added)
 *
 *
 *  i = 6 | 76
 *
 * stack => 2 => 5 (removed)
 * result[5] = 6 - 5 = 1
 * result => [1, 1, 0, 2, 1, 1, 0, 0]
 *
 * stack => 2 (removed)
 * result[2] = 6 - 2 = 4
 * result => [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * stack => 6
 *
 * i = 7 | 73
 * stack => 6 => 7
 * result => [1, 1, 4, 2, 1, 1, 0, 0]

 */
fun getWarmerTemperatureDays(temperatures: Array<Int>): IntArray {
    val result = IntArray(temperatures.size)
    val stack = mutableListOf<Int>() // Stack to store indices

    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
            val prevIndex = stack.removeAt(stack.lastIndex)
            result[prevIndex] = i - prevIndex
        }
        stack.add(i)
    }

    return result
}
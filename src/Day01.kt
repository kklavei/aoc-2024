import kotlin.math.absoluteValue

fun main() {
    fun readColumns(input: List<String>): List<IntArray> {
        val inputSize = input.size
        val leftIntArray = IntArray(inputSize)
        val rightIntArray = IntArray(inputSize)
        for (i in input.indices) {
            val pair: List<String> = input[i].split("   ")
            leftIntArray[i] = pair[0].toInt()
            rightIntArray[i] = pair[1].toInt()
        }
        return listOf(leftIntArray, rightIntArray)
    }

    fun part1(input: List<String>): Int {
        val columns = readColumns(input)
        val leftList = columns[0]
        val rightList = columns[1]
        leftList.sort()
        rightList.sort()
        var sum = 0
        for (i in leftList.indices) {
            sum += (leftList[i] - rightList[i]).absoluteValue
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val columns = readColumns(input)
        val leftList = columns[0]
        val rightList = columns[1]
        var sum = 0
        for (i in leftList.indices) {
            val c = rightList.count { it == leftList[i] }
            sum += (leftList[i] * c)
        }
        return sum
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

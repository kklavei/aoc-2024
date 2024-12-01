import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val inputSize = input.size
        val leftList = IntArray(inputSize)
        val rightList = IntArray(inputSize)
        for (i in input.indices) {
            val pair: List<String> = input[i].split("   ")
            leftList[i] = pair[0].toInt()
            rightList[i] = pair[1].toInt()
        }
        leftList.sort()
        rightList.sort()
        var sum = 0
        for (i in leftList.indices) {
            sum += (leftList[i] - rightList[i]).absoluteValue
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

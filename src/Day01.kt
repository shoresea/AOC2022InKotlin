fun main() {
    fun part1(inputs: List<String>): Int {
        var max = 0
        var sum = 0
        for(input in inputs){
            if(input == "") {
                max = maxOf(max, sum)
                sum = 0
            } else {
                sum += input.toInt()
            }
        }
        return max
    }

    fun part2(inputs: List<String>): Int {
        val sums = ArrayList<Int>()
        var sum = 0
        for(input in inputs) {
            if (input == "") {
                sums.add(sum)
                sum = 0
            } else {
                sum += input.toInt()
            }
        }
        return sums.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

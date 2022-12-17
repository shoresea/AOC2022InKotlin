fun main() {
    fun part1(inputs: List<String>): Int {
        return getMarker(inputs[0], 4)
    }

    fun part2(inputs: List<String>): Int {
        return getMarker(inputs[0], 14)
    }

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}

fun getMarker(input: String, distinct: Int = 4): Int {
    var l = 0
    while (l <= input.lastIndex - (distinct - 1)) {
        if (input.substring(l, l + distinct).hasUniqueChars()) {
            break
        }
        l++
    }
    return l + distinct
}

fun String.hasUniqueChars(): Boolean = this.length == this.toCharArray().toSet().size

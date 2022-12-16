fun main() {
    fun part1(inputs: List<String>): Int {
        var sum = 0
        for (input in inputs) {
            sum += getPriority(input)
        }
        return sum
    }

    fun part2(inputs: List<String>): Int {
        var sum = 0
        var i = 0
        while (i < inputs.size) {
            sum += calculateBadgePriority(inputs[i++], inputs[i++], inputs[i++])
        }
        return sum
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

fun calculateBadgePriority(g1: String, g2: String, g3: String): Int {
    val chars1 = g1.toCharArray().toSet()
    val chars2 = g2.toCharArray().toSet()
    var commons = chars1.intersect(chars2)
    val chars3 = g3.toCharArray().toSet()
    commons = chars3.intersect(commons)
    return priorityOf(commons.single())
}

fun getPriority(input: String): Int {
    var sum = 0
    val len = input.length / 2
    val chars1 = input.substring(0, len).toCharArray().toSet()
    val chars2 = input.substring(len, input.length).toCharArray().toSet()

    for (ch in chars2) {
        if (chars1.contains(ch)) {
            sum += priorityOf(ch)
        }
    }
    return sum
}

fun priorityOf(char: Char): Int {
    if (char in ('a'..'z')) {
        return char.code - 96
    }
    return char.code - 64 + 26
}
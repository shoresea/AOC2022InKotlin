fun main() {
    fun part1(inputs: List<String>): Int {
        return inputs.map {
            val input = it.split(",")
            fullyContainOther(input[0], input[1])
        }.count { it }
    }

    fun part2(inputs: List<String>): Int {
        return inputs.map {
            val input = it.split(",")
            overlaps(input[0], input[1])
        }.count { it }
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

fun overlaps(r1: String, r2: String): Boolean {
    val range1 = r1.split("-").map { it.toInt() }.let { (it[0]..it[1]) }
    val range2 = r2.split("-").map { it.toInt() }.let { (it[0]..it[1]) }
    return range1.union(range2).size < (range1.toSet().size + range2.toSet().size)
}

fun fullyContainOther(r1: String, r2: String): Boolean {
    val range1 = r1.split("-").map { it.toInt() }.let { (it[0]..it[1]) }
    val range2 = r2.split("-").map { it.toInt() }.let { (it[0]..it[1]) }
    return range1.union(range2) == range1.toSet() || range1.union(range2) == range2.toSet()
}
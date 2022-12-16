fun main() {
    fun part1(inputs: List<String>): Int {
        var score = 0
        for (input in inputs) {
            val moves = input.split(" ")
            score += calculateScore(moves[0], moves[1])
        }
        return score
    }

    fun part2(inputs: List<String>): Int {
        var score = 0
        for (input in inputs) {
            val moves = input.split(" ")
            score += calculateScore2(moves[0], moves[1])
        }
        return score
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun calculateScore(p1: String, p2: String): Int {
    var score = 0
    if (p2 == "X") {
        score += 1
        if (p1 == "A") {
            score += 3
        } else if (p1 == "B") {
            score += 0
        } else if (p1 == "C") {
            score += 6
        }
    } else if (p2 == "Y") {
        score += 2
        if (p1 == "A") {
            score += 6
        } else if (p1 == "B") {
            score += 3
        } else if (p1 == "C") {
            score += 0
        }
    } else if (p2 == "Z") {
        score += 3
        if (p1 == "A") {
            score += 0
        } else if (p1 == "B") {
            score += 6
        } else if (p1 == "C") {
            score += 3
        }
    }
    return score
}

fun calculateScore2(p1: String, p2: String): Int {
    var score = 0
    if (p2 == "X") {
        score += 0
        if (p1 == "A") {
            score += 3
        } else if (p1 == "B") {
            score += 1
        } else if (p1 == "C") {
            score += 2
        }
    } else if (p2 == "Y") {
        score += 3
        if (p1 == "A") {
            score += 1
        } else if (p1 == "B") {
            score += 2
        } else if (p1 == "C") {
            score += 3
        }
    } else if (p2 == "Z") {
        score += 6
        if (p1 == "A") {
            score += 2
        } else if (p1 == "B") {
            score += 3
        } else if (p1 == "C") {
            score += 1
        }
    }
    return score
}

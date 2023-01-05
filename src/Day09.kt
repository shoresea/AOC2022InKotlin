fun main() {

    fun makeMove(
        dir: String,
        move: Int,
        visited: MutableList<MutableList<Char>>,
        head: Point,
        tail: Point
    ): Result {
        // expand grid if required
        if (dir == "U" && (head.r - move) < 0) {
            val additionalRows = move - head.r
            repeat(additionalRows) {
                visited.add(0, MutableList(visited[0].size) { ' ' })
            }
            head.r = move
            tail.r = tail.r + additionalRows
        } else if (dir == "D" && (head.r + move) > visited.lastIndex) {
            val additionalRows = head.r + move - visited.lastIndex
            repeat(additionalRows) {
                visited.add(visited.size, MutableList(visited[0].size) { ' ' })
            }
        } else if (dir == "L" && (head.c - move) < 0) {
            val additionalColumns = move - head.c
            repeat(additionalColumns) {
                visited.forEach { it.add(0, ' ') }
            }
            head.c = move
            tail.c = tail.c + additionalColumns
        } else if (dir == "R" && (head.c + move) > visited[0].lastIndex) {
            val additionalColumns = head.c + move - visited.lastIndex
            repeat(additionalColumns) {
                visited.forEach { it.add(' ') }
            }
        }
        // end of extending

        if (dir == "U") {
            repeat(move) {
                head.r -= 1
                if (tail.r == head.r + 2 && tail.c == head.c - 1) {
                    tail.r -= 1
                    tail.c += 1
                } else if (tail.r == head.r + 2 && tail.c == head.c) {
                    tail.r -= 1
                } else if (tail.r == head.r + 2 && tail.c == head.c + 1) {
                    tail.r -= 1
                    tail.c -= 1
                }
                visited[tail.r][tail.c] = '#'
            }
        } else if (dir == "D") {
            repeat(move) {
                head.r += 1
                if (tail.r == head.r - 2 && tail.c == head.c - 1) {
                    tail.r += 1
                    tail.c += 1
                } else if (tail.r == head.r - 2 && tail.c == head.c) {
                    tail.r += 1
                } else if (tail.r == head.r - 2 && tail.c == head.c + 1) {
                    tail.r += 1
                    tail.c -= 1
                }
                visited[tail.r][tail.c] = '#'
            }
        } else if (dir == "L") {
            repeat(move) {
                head.c -= 1
                if (tail.r == head.r - 1 && tail.c == head.c + 2) {
                    tail.r += 1
                    tail.c -= 1
                } else if (tail.r == head.r && tail.c == head.c + 2) {
                    tail.c -= 1
                } else if (tail.r == head.r + 1 && tail.c == head.c + 2) {
                    tail.r -= 1
                    tail.c -= 1
                }
                visited[tail.r][tail.c] = '#'
            }
        } else if (dir == "R") {
            repeat(move) {
                head.c += 1
                if (tail.r == head.r - 1 && tail.c == head.c - 2) {
                    tail.r += 1
                    tail.c += 1
                } else if (tail.r == head.r && tail.c == head.c - 2) {
                    tail.c += 1
                } else if (tail.r == head.r + 1 && tail.c == head.c - 2) {
                    tail.r -= 1
                    tail.c += 1
                }
                visited[tail.r][tail.c] = '#'
            }
        }
        return Result(visited, head, tail)
    }

    fun part1(inputs: List<String>): Int {
        var visited = MutableList(100) { MutableList<Char>(100) { ' ' } }
        visited[50][50] = '#'

        var head = Point(50, 50)
        var tail = Point(50, 50)
        for (input in inputs) {
            val (dir, move) = input.split(" ").let { it[0] to it[1].toInt() }
            val result = makeMove(dir, move, visited, head, tail)
            visited = result.visited
            head = result.head
            tail = result.tail
        }
        return visited.sumOf { row -> row.count { it == '#' } }
    }

    fun part2(inputs: List<String>): Int {
        return 0
    }

    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}

data class Point(var r: Int, var c: Int) // row, column

data class Result(
    var visited: MutableList<MutableList<Char>>,
    var head: Point,
    var tail: Point
)


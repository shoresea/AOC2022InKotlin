fun main() {

    fun step(snake: List<Point>, currHeadIndex: Int, currTailIndex: Int) {
        // region Up
        /*
        - - - - -
        - - H - -
        - - s - -
        - T T T -
        - - - - -
         */
        if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 1) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c += 1
            // UR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r -= 1
            // U
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 1) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c -= 1
            // UL
        }
        // endregion Up
        // region Down
        /*
        - - - - -
        - T T T -
        - - s - -
        - - H - -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 1) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c += 1
            // DR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r += 1
            // D
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 1) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c -= 1
            // DL
        }
        //endregion Down
        //region Left
        /*
        - - - - -
        - - - T -
        - H s T -
        - - - T -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r - 1 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c -= 1
            // DL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].c -= 1
            // L
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 1 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c -= 1
            // UL
        }
        //endregion Left
        //region Right
        /*
        - - - - -
        - T - - -
        - T s H -
        - T - - -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r - 1 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c += 1
            // DR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].c += 1
            // R
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 1 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c += 1
            // UR
        }
        // endregion Right
        // region UpRight
        /*
        - - - - -
        - T - H -
        - T s - -
        - T T T -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c += 1
            // UR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 1) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c += 1
            // UR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r -= 1
            // U
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].c += 1
            // R
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 1 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c += 1
            // UR
        }
        //endregion UpRight
        // region UpLeft
        /*
        - - - - -
        - H - T -
        - - s T -
        - T T T -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].c -= 1
            // L
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 1 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c -= 1
            // UL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c -= 1
            // UL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 1) {
            snake[currTailIndex].r -= 1
            snake[currTailIndex].c -= 1
            // UL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r + 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r -= 1
            // U
        }
        // endregion UpLeft
        // region DownRight
        /*
        - - - - -
        - T T T -
        - T s - -
        - T - H -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c += 1
            // DR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c - 1) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c += 1
            // DR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r += 1
            // D
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 1 && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c += 1
            // DR
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c - 2) {
            snake[currTailIndex].c += 1
            // R
        }
        // endregion DownRight
        // region DownLeft
        /*
        - - - - -
        - T T T -
        - - s T -
        - H - T -
        - - - - -
         */
        else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c -= 1
            // DL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c + 1) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c -= 1
            // DL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 2 && snake[currTailIndex].c == snake[currHeadIndex].c) {
            snake[currTailIndex].r += 1
            // D
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r - 1 && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].r += 1
            snake[currTailIndex].c -= 1
            // DL
        } else if (snake[currTailIndex].r == snake[currHeadIndex].r && snake[currTailIndex].c == snake[currHeadIndex].c + 2) {
            snake[currTailIndex].c -= 1
            // L
        }
        // endregion Down Left
    }

    fun expandGridIfRequired(
        dir: String, move: Int,
        visited: MutableList<MutableList<Char>>,
        snake: List<Point>,
    ) {
        val head = snake.first()
        if (dir == "U" && (head.r - move) < 0) {
            val additionalRows = move - head.r
            repeat(additionalRows) {
                visited.add(0, MutableList(visited[0].size) { ' ' })
            }
            head.r = move
            snake.stream().skip(1).forEach { it.r = it.r + additionalRows }
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
            snake.stream().skip(1).forEach { it.c = it.c + additionalColumns }
        } else if (dir == "R" && (head.c + move) > visited[0].lastIndex) {
            val additionalColumns = head.c + move - visited.lastIndex
            repeat(additionalColumns) {
                visited.forEach { it.add(' ') }
            }
        }
    }

    fun makeMove(
        dir: String,
        move: Int,
        visited: MutableList<MutableList<Char>>,
        snake: List<Point>,
    ): Result {
        expandGridIfRequired(dir, move, visited, snake)
        repeat(move) {
            var currHeadIndex = 0
            var currTailIndex = 1
            if (dir == "U") {
                snake[currHeadIndex].r -= 1
            } else if (dir == "D") {
                snake[currHeadIndex].r += 1
            } else if (dir == "L") {
                snake[currHeadIndex].c -= 1
            } else if (dir == "R") {
                snake[currHeadIndex].c += 1
            }
            while (currTailIndex <= snake.lastIndex) {
                step(snake, currHeadIndex, currTailIndex)
                currHeadIndex++
                currTailIndex++
            }
            visited[snake.last().r][snake.last().c] = '#'
        }
        return Result(visited, snake)
    }

    fun part1(inputs: List<String>): Int {
        var visited = MutableList(100) { MutableList<Char>(100) { ' ' } }
        var snake = (0..1).map { Point(50, 50) }
        for (input in inputs) {
            val (dir, move) = input.split(" ").let { it[0] to it[1].toInt() }
            val result = makeMove(dir, move, visited, snake)
            visited = result.visited
            snake = result.snake
        }
        return visited.sumOf { row -> row.count { it == '#' } }
    }

    fun part2(inputs: List<String>): Int {
        var visited = MutableList(100) { MutableList<Char>(100) { ' ' } }
        var snake = (0..9).map { Point(50, 50) }
        for (input in inputs) {
            val (dir, move) = input.split(" ").let { it[0] to it[1].toInt() }
            val result = makeMove(dir, move, visited, snake)
            visited = result.visited
            snake = result.snake
        }
        // visited.forEach { if (it.contains('#')) println(it) }
        return visited.sumOf { row -> row.count { it == '#' } }
    }

    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}

data class Point(var r: Int, var c: Int) // row, column

data class Result(
    var visited: MutableList<MutableList<Char>>,
    var snake: List<Point>,
) {
    fun head(): Point = snake.first()
    fun tail(): Point = snake.last()
}


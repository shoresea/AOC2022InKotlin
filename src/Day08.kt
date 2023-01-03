fun main() {

    fun generateGrid(inputs: List<String>): List<List<Int>> {
        return inputs.map { input ->
            input.trim().split("").filter { it != "" }.map { it.toInt() }
        }
    }

    fun isMaxUp(i: Int, j: Int, grid: List<List<Int>>): Boolean {
        for (index in 0 until i) {
            if (grid[index][j] >= grid[i][j]) return false
        }
        return true
    }

    fun isMaxDown(i: Int, j: Int, grid: List<List<Int>>): Boolean {
        for (index in i + 1 until grid.size) {
            if (grid[index][j] >= grid[i][j]) return false
        }
        return true
    }

    fun isMaxLeft(i: Int, j: Int, grid: List<List<Int>>): Boolean {
        for (index in 0 until j) {
            if (grid[i][index] >= grid[i][j]) return false
        }
        return true
    }

    fun isMaxRight(i: Int, j: Int, grid: List<List<Int>>): Boolean {
        for (index in j + 1 until grid[i].size) {
            if (grid[i][index] >= grid[i][j]) return false
        }
        return true
    }

    fun isVisible(i: Int, j: Int, grid: List<List<Int>>): Boolean {
        if (i == 0 || j == 0 || i == grid.lastIndex || j == grid[0].lastIndex) return true
        if (isMaxUp(i, j, grid)) return true
        if (isMaxDown(i, j, grid)) return true
        if (isMaxLeft(i, j, grid)) return true
        if (isMaxRight(i, j, grid)) return true
        return false
    }

    fun scenicScoreUp(i: Int, j: Int, grid: List<List<Int>>): Int {
        for (index in i - 1 downTo 0) {
            if (grid[index][j] >= grid[i][j]) return i - index
        }
        return i - 0
    }

    fun scenicScoreDown(i: Int, j: Int, grid: List<List<Int>>): Int {
        for (index in i + 1 until grid.size) {
            if (grid[index][j] >= grid[i][j]) return index - i
        }
        return grid.lastIndex - i
    }

    fun scenicScoreLeft(i: Int, j: Int, grid: List<List<Int>>): Int {
        for (index in j - 1 downTo 0) {
            if (grid[i][index] >= grid[i][j]) return j - index
        }
        return j - 0
    }

    fun scenicScoreRight(i: Int, j: Int, grid: List<List<Int>>): Int {
        for (index in j + 1 until grid[i].size) {
            if (grid[i][index] >= grid[i][j]) return index - j
        }
        return grid[i].lastIndex - j
    }

    fun scenicScore(i: Int, j: Int, grid: List<List<Int>>): Int {
        if (i == 0 || j == 0 || i == grid.lastIndex || j == grid[0].lastIndex) return 0
        val up: Int = scenicScoreUp(i, j, grid)
        val down: Int = scenicScoreDown(i, j, grid)
        val left: Int = scenicScoreLeft(i, j, grid)
        val right: Int = scenicScoreRight(i, j, grid)
        return up * down * left * right
    }

    fun part1(inputs: List<String>): Int {
        val grid: List<List<Int>> = generateGrid(inputs)
        var count = 0
        for ((i, row) in grid.withIndex()) {
            for ((j, _) in row.withIndex()) {
                count += if (isVisible(i, j, grid)) 1 else 0
            }
        }
        return count
    }

    fun part2(inputs: List<String>): Int {
        val grid: List<List<Int>> = generateGrid(inputs)
        var max = 0
        for ((i, row) in grid.withIndex()) {
            for ((j, _) in row.withIndex()) {
                max = maxOf(max, scenicScore(i, j, grid))
            }
        }
        return max
    }

    val input = readInput("Day08")
    part1(input).println()
    part2(input).println()
}


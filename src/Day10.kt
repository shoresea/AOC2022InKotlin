fun main() {

    fun process(command: String, value: Int?, cpu: CPU) {
        when (command) {
            "noop" -> {
                cpu.completeCycle()
            }
            "addx" -> {
                repeat(2) {
                    cpu.completeCycle()
                }
                cpu.addValue(value!!)
            }
        }
    }

    fun part1(inputs: List<String>): Int {
        val cpu = CPU(0, 1, 0)
        for (input in inputs) {
            val (command, value) = input.split(" ").let { it[0] to (if (it.size == 1) null else it[1].toInt()) }
            process(command, value, cpu)
        }
        return cpu.strength()
    }

    fun part2(inputs: List<String>): Int {
        return 0
    }

    val input = readInput("Day10")
    part1(input).println()
    part2(input).println()
}

data class CPU(private var cycle: Int, private var X: Int, private var strength: Int) {

    fun completeCycle() {
        cycle++
        updateStrength()
    }

    private fun updateStrength() {
        val currentStrength = when (cycle) {
            20, 60, 100, 140, 180, 220 -> {
                cycle * X
            }
            else -> 0
        }
        strength += currentStrength
    }

    fun addValue(value: Int) {
        X += value
    }

    fun strength() = strength
}

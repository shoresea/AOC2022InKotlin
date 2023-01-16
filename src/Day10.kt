import Command.Instruction.addx
import Command.Instruction.noop

fun main() {

    fun part1(inputs: List<String>): Int {
        val cpu = CPU()
        for (input in inputs) {
            val command = Command.parseFrom(input)
            cpu.process(command)
        }
        return cpu.strength()
    }

    fun part2(inputs: List<String>): String {
        val cpu = CPU()
        for (input in inputs) {
            val command = Command.parseFrom(input)
            cpu.process(command)
        }
        return cpu.CRT()
    }

    val input = readInput("Day10")
    part1(input).println()
    part2(input).println()
}

data class Command(val instruction: Instruction, val value: Int?) {

    enum class Instruction {
        addx,
        noop
    }

    companion object {
        fun parseFrom(input: String): Command = input.split(" ").let {
            Command(
                instruction = Instruction.valueOf(it[0]),
                value = if (it.size == 1) null else it[1].toInt(),
            )
        }
    }
}

data class CPU(
    private var cycle: Int = 0,
    private var X: Int = 1,
    private var strength: Int = 0,
    private var crt: MutableList<Char> = MutableList(240) { '.' },
) {

    fun process(command: Command) {
        when (command.instruction) {
            noop -> {
                completeCycle(1)
            }
            addx -> {
                completeCycle(2)
                addValue(command.value!!)
            }
        }
    }

    private fun completeCycle(times: Int = 1) {
        repeat(times) {
            drawOnCrt()
            cycle++
            updateStrength()
        }
    }

    private fun drawOnCrt() {
        if (doesSpriteCollidesWithCRTCycle())
            crt[cycle] = '#'
    }

    private fun doesSpriteCollidesWithCRTCycle(): Boolean = ((X - 1)..(X + 1)).contains(cycle % 40)

    private fun updateStrength() {
        val additionalStrength = when (cycle) {
            20, 60, 100, 140, 180, 220 -> {
                cycle * X
            }
            else -> 0
        }
        strength += additionalStrength
    }

    private fun addValue(value: Int) {
        X += value
    }

    fun strength() = strength

    fun CRT() = (0..5).joinToString("\n") {
        val start = it * 40
        val end = (it + 1) * 40
        crt.subList(start, end).joinToString(" ")
    }
}

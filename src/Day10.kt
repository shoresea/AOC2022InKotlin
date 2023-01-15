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

    fun part2(inputs: List<String>): Int {
        return 0
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
    private var strength: Int = 0
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
            cycle++
            updateStrength()
        }
    }

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
}

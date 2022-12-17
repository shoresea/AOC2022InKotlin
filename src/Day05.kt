import java.util.*

fun main() {
    fun part1(inputs: List<String>): String {
        val stacksCount = (inputs[0].length / 4) + 1
        //println("StacksCount :: $stacksCount")
        val stacks = ArrayList<Stack<Char>>()
        for (i in 1..stacksCount) {
            stacks.add(Stack<Char>())
        }
        for (input in inputs) {
            if (input.trim().startsWith("1")) {
                break
            } else {
                val row = input
                    .replace(" [", "#[")
                    .replace("] ", "]#")
                    .replace("    ", "#")
                    .let {
                        if (it.contains("#")) it.split("#") else it.split("  ")
                    }.map {
                        it.removeSuffix("]")
                            .removePrefix("[")
                            .trim()
                    }
                for ((index, element) in row.withIndex()) {
                    if (element.isNotEmpty()) {
                        stacks[index].push(element[0])
                    }
                }
                // println(row)
            }
        }
        stacks.forEach { it.reverse() }
        //println(stacks)

        for (input in inputs) {
            if (!input.trim().startsWith("move")) {
                continue
            }
            val move = input.replace("move ", "")
                .replace(" from ", ",")
                .replace(" to ", ",")
                .split(",")
                .map { it.toInt() }
            //println(move)
            repeat(move[0]) {
                val from = stacks[move[1] - 1]
                val to = stacks[move[2] - 1]
                to.push(from.pop())
            }
        }
        //println(stacks)
        return stacks.map { it.peek() }.joinToString("")
    }


    fun part2(inputs: List<String>): String {
        val stacksCount = (inputs[0].length / 4) + 1
        //println("StacksCount :: $stacksCount")
        val stacks = ArrayList<Stack<Char>>()
        for (i in 1..stacksCount) {
            stacks.add(Stack<Char>())
        }
        for (input in inputs) {
            if (input.trim().startsWith("1")) {
                break
            } else {
                val row = input
                    .replace(" [", "#[")
                    .replace("] ", "]#")
                    .replace("    ", "#")
                    .let {
                        if (it.contains("#")) it.split("#") else it.split("  ")
                    }.map {
                        it.removeSuffix("]")
                            .removePrefix("[")
                            .trim()
                    }
                for ((index, element) in row.withIndex()) {
                    if (element.isNotEmpty()) {
                        stacks[index].push(element[0])
                    }
                }
                //println(row)
            }
        }
        stacks.forEach { it.reverse() }
        //println(stacks)

        for (input in inputs) {
            if (!input.trim().startsWith("move")) {
                continue
            }
            val move = input.replace("move ", "")
                .replace(" from ", ",")
                .replace(" to ", ",")
                .split(",")
                .map { it.toInt() }
            // println(move)
            val from = stacks[move[1] - 1]
            val to = stacks[move[2] - 1]
            (1..move[0]).map { from.pop() }.reversed().forEach { to.push(it) }
        }
        // println(stacks)
        return stacks.map { it.peek() }.joinToString("")
    }

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}


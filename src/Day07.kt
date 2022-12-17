import java.util.*

fun main() {
    fun getDirectories(root: Directory): List<Directory> {
        val directories = ArrayList<Directory>()
        val queue = Stack<Directory>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val current = queue.pop()
            directories.add(current)
            current.children.filterIsInstance<Directory>().let { queue.addAll(it) }
        }
        return directories
    }

    fun generateFilesystem(inputs: List<String>): Directory {
        val root = Directory("/", ArrayList(), null)
        var current: FileSystemNode = root
        for (input in inputs) {
            if (input.startsWith("$ cd ")) {
                current = current as Directory
                val dirName = input.substringAfter("$ cd ").trim()
                current = when (dirName) {
                    "/" -> {
                        root
                    }
                    ".." -> {
                        current.parent!!
                    }
                    else -> {
                        current.children.firstOrNull { it.name == dirName }
                            ?: Directory(dirName, ArrayList(), current)
                                .also { (current as Directory).children.add(it) }
                    }
                }
            } else if (input.startsWith("$ ls")) {
                continue
            } else {
                if (input.startsWith("dir")) {
                    Directory(input.substringAfter("dir ").trim(), ArrayList(), current)
                        .also { (current as Directory).children.add(it) }
                } else {
                    val props = input.split(" ").map { it.trim() }
                    File(props[1], props[0].toInt())
                        .also { (current as Directory).children.add(it) }
                }
            }
        }
        return root
    }

    fun part1(inputs: List<String>): Int {
        val root = generateFilesystem(inputs)
        return getDirectories(root).map { it.size() }.filter { it <= 100000 }.sum()
    }

    fun part2(inputs: List<String>): Int {
        val root = generateFilesystem(inputs)
        val availableStorage = 70000000 - root.size()
        val requiredFreeStorage = 30000000 - availableStorage
        return getDirectories(root).map{ it.size() }.filter { it >= requiredFreeStorage }.min()
    }

    val input = readInput("Day07")
    part1(input).println()
    part2(input).println()
}

abstract class FileSystemNode(open val name: String) {
    abstract fun size(): Int
}

data class File(override val name: String, private val size: Int) : FileSystemNode(name) {
    override fun size(): Int = size
}

data class Directory(override val name: String, val children: ArrayList<FileSystemNode>, val parent: FileSystemNode?) :
    FileSystemNode(name) {
    override fun size(): Int = children.sumOf { it.size() }
}
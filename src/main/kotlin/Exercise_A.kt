import java.io.File

fun main(args: Array<String>) {
    val cargoRaw = getCargoList(args)
    val cargoMaxEdges = getSortedEdges(cargoRaw)
    val mediumEdge = getMediumEdge(cargoMaxEdges)
    println(mediumEdge)
}

private fun getCargoList(args: Array<String>): List<String> {
    var inputList: MutableList<String> = mutableListOf()

    if (args.size == 1) {
        inputList = File(args[0]).readLines().toMutableList()
    } else {
        val cargoCount = readLine()?.toInt() ?: 0
        if (cargoCount != 0) {
            for (i in 0..cargoCount) {
                readLine()?.let { inputList.add(it) }
            }
        } else {
            throw IllegalArgumentException("No arguments found")
        }
    }
    return inputList.toList()
}

private fun getSortedEdges(input: List<String>): List<Int> {
    val res = input.subList(1, input[0].toInt() + 1)
        .map {
            it.split(" ")
                .subList(1, 4).maxOf { it2 ->
                    it2.toInt()
                }
        }
    return res.sorted()
}

private fun getMediumEdge(edges: List<Int>): Int {
    val isEven = if (edges.size % 2 == 0) 1 else 0
    return edges[edges.size / 2 - isEven]
}

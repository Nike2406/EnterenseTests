import java.io.File

fun main(args: Array<String>) {
    println("${mostCompChar(args)}")
}

fun mostCompChar(args: Array<String>): Char {
    val inputString: String
    val digits: List<Int>
    if (args.size == 1) {
        val input = File(args[0]).readLines()
        input[0].toInt()
        inputString = input[1]
        digits = input[2]
            .split(" ")
            .map { it.toInt() }
    } else {
        readLine()!!.toInt()
        inputString = readLine()!!
        digits = readLine()!!
            .split(" ")
            .map { it.toInt() }
    }
    val res = findMaxIndex(inputString, digits)
    return res
}

fun findMaxIndex(inputString: String, digits: List<Int>): Char {
    var result: Char = inputString.first()
    var maxTime: Double = -1.0
    val mapTime = mutableMapOf<Char, Int>()
    val mapCounter = mutableMapOf<Char, Int>()

    mapTime[inputString.first()] = digits[0]
    mapCounter[inputString.first()] = 1
    for (i in 1..inputString.lastIndex) {
        if (inputString[i] in 'a'..'z' || inputString[i] in 'A'..'Z') {
            if (mapTime.containsKey(inputString[i])) {
                mapCounter[inputString[i]] = mapCounter[inputString[i]]!! + 1
                mapTime[inputString[i]] = mapTime[inputString[i]]!! + digits[i] - digits[i - 1]
            } else {
                mapTime[inputString[i]] = digits[i] - digits[i - 1]
                mapCounter[inputString[i]] = 1
            }
        }
    }
    mapTime.map {
        if ((it.value / mapCounter[it.key]!!).toDouble() >= maxTime) {
            maxTime = (it.value / mapCounter[it.key]!!).toDouble()
        }
    }

    for (i in 1..inputString.lastIndex) {
        if ((mapTime[inputString[i]]!! / mapCounter[inputString[i]]!!).toDouble() == maxTime) {
            result = inputString[i]
        }
    }

//    for (i in 1..digits.lastIndex) {
//
//        if (digits[i] - digits[i - 1] > maxTime) {
//            maxIndex = i
//            maxTime = digits[i] - digits[i - 1]
//        }
//    }
    return result
}

import java.io.File

fun main(args: Array<String>) {
    println("${sumOfTwo(args)}")
}

fun sumOfTwo(args: Array<String>): Long {
    val input = File(args[0]).readLines()
    val inputFromFileArray = input[0].split(' ').toTypedArray()
    val sum = inputFromFileArray[0].toLong() + inputFromFileArray[1].toLong()
    File("output.txt").writeText(sum.toString())
    return sum
}
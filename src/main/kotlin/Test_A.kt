import java.io.File
import java.util.Scanner

fun main(args: Array<String>) {
    println("${sumOfTwo(args)}")
}

fun sumOfTwo(args: Array<String>): Long {
    if (args.size == 2) {
        return args[0].toLong() + args[1].toLong()
    } else if (args.size == 1) {
        val input = File(args[0]).readLines()
        val inputFromFileArray = input[0].split(' ').toTypedArray()
        return inputFromFileArray[0].toLong() + inputFromFileArray[1].toLong()
    } else if (args.isEmpty()) {
        val scan = Scanner(System.`in`)
        val a = scan.nextLong()
        val b = scan.nextLong()
        return  a + b
    }
    return 0
}
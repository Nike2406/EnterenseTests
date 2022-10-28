import java.io.File
import java.util.Scanner

fun main(args: Array<String>) {
    println("${sumOfTwo(args)}")
}

fun sumOfTwo(args: Array<String>): Long {
 val arr = readLine()!!.split(" ").map {it.toLong()}
 return  arr[0] + arr[1]
}
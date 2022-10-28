import java.io.File

fun main(args: Array<String>) {
    println("${getUnicUsers(args)}")
}

fun getUnicUsers(args: Array<String>): Int {
    var days: Int = 0
    var tempMails = mutableListOf<Int>()
    if (args.size == 1) {
        val input = File(args[0]).readLines()
        days = input[0].toInt()
        tempMails = input[1].split(" ").toTypedArray().forEach { it = it.toInt() }
//        for (i in tempMails)
//            i = i.toInt()
    } else {
        days = readLine()!!.toInt()
        for (i in 1..days) {
            tempMails += readLine()!!
        }
    }
    val users = getPick()
    return users.size
}


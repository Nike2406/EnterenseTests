import java.io.File

fun main(args: Array<String>) {
    println("${getUnicUsers(args)}")
}

fun getUnicUsers(args: Array<String>): Int {
    var loginCount: Int = 0
    val tempMails: MutableList<String> = mutableListOf()
    if (args.size == 1) {
        val input = File(args[0]).readLines()
        loginCount = input[0].toInt()
        for (i in 1..loginCount) {
            tempMails += input[i]
        }
    } else {
        loginCount = readLine()!!.toInt()
        for (i in 1..loginCount) {
            tempMails += readLine()!!
        }
    }
    val users = buildLoginsMap(tempMails)
    return users.size
}
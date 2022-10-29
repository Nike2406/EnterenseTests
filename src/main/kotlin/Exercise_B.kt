import java.io.File

/*
* 1str: n, k, w
* n - количество билбордов
* k - кол-во работодателей
* w - кол-во недель размещения
* K-str: c, w
* c - цена раб-ля за 1 неделю
* w - на сколько недель выставил
* */
fun main(args: Array<String>) {
    val rawData: List<String> = parseInputData(args)
    val inputInfo: InputInfo = parseInfo(rawData)
    val employees: Array<Employer> = parseEmployer(inputInfo, rawData)

    val sortedByDescendingProfit: List<Employer> = employees.copyOf()
        .sortedDescending()
        .toList()

    println(employees.contentToString())
    employees.sortByDescending{it.profit}
    println(employees.contentToString())

}

fun parseInputData(args: Array<String>): List<String> {
    var inputList1: MutableList<String> = mutableListOf()

    if (args.size == 1) {
        inputList1 = File(args[0]).readLines().toMutableList()
    } else {
        val firstLine = readLine() ?: ""
        inputList1.add(firstLine)
        val linesCount = firstLine.split(" ")[1].toInt()
        for (i in 0 until linesCount) {
            readLine()?.let { inputList1.add(it) }
        }
    }
    return inputList1.toList()
}

fun parseInfo(rawData: List<String>): InputInfo {
    val rawInputInfo = rawData[0].split(" ")
        .map {
            it.toInt()
        }
    return InputInfo(
        rawInputInfo[0],
        rawInputInfo[1],
        rawInputInfo[2]
    )
}

fun parseEmployer(
    inputInfo: InputInfo,
    rawData: List<String>
): Array<Employer> {
    val employerArr: Array<Employer> = Array(inputInfo.employersCount) {
        Employer(-1, -1, -1, -1)
    }
    var tempEmployerData: List<Int>
    for (i in 0 until inputInfo.employersCount) {
        employerArr[i].id = i
        tempEmployerData = getEmployerData(rawData[i + 1])
        employerArr[i].pricePerWeek = tempEmployerData[0]
        employerArr[i].weeksCount = tempEmployerData[1]
        employerArr[i].profit = tempEmployerData[0] * tempEmployerData[1]
    }
    return employerArr
}

private fun getEmployerData(str: String): List<Int> {
    val tempArr = str.split(" ")
        .map {
            it.toInt()
        }
    return tempArr
}

data class InputInfo(
    val billboardsCount: Int,
    val employersCount: Int,
    val weeksCount: Int,
)

data class Employer(
    var id: Int,
    var pricePerWeek: Int,
    var weeksCount: Int,
    var profit: Int,
) : Comparable<Employer> {
    override fun compareTo(other: Employer): Int {
        return if (this.profit > other.profit)
            1
        else if (this.profit < other.profit)
            -1
        else
            0
    }
}

data class Billboard(
    val id: Int,
    val setOfCurrentEmployees: Set<Employer>,
    val freeWeeks: Int,
)


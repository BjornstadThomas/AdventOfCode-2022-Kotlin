fun main() {


    fun splitString(input: String): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
//        val inputSplit = input.split("\r\n")
        val inputSplit = input.lines().map {
            val list = it.split(",").map { it.split("-") }

//            println(list)
            (list[0][0].toInt() to list[0][1].toInt()) to (list[1][0].toInt() to list[1][1].toInt())
        }

        println(inputSplit)

        return inputSplit
    }

    fun checkIfItContainsFully(firstRange: Pair<Int, Int>, secondRange: Pair<Int, Int>): Boolean {
        return firstRange.first <= secondRange.first && firstRange.second >= secondRange.second
    }

    fun getNumberOfPairsWithSectionsFullyOverlapping(liste: List<Pair<Pair<Int,Int>,Pair<Int,Int>>>): String {
        return liste.count {checkIfItContainsFully(it.first, it.second) || checkIfItContainsFully(it.second, it.first) }.toString()
    }

    fun checkIfItContainsParts(firstRange: Pair<Int, Int>, secondRange: Pair<Int, Int>): Boolean {
        return firstRange.first <= secondRange.first && firstRange.second >= secondRange.first
    }

    fun getNumberOfPairsWithSectionsParlyOverlapping(liste: List<Pair<Pair<Int,Int>,Pair<Int,Int>>>): String {
        return liste.count {checkIfItContainsParts(it.first, it.second) || checkIfItContainsParts(it.second, it.first) }.toString()
    }

    fun part1(input: String): String {
        val liste = splitString(input)
        val containsFully = getNumberOfPairsWithSectionsFullyOverlapping(liste)
        return containsFully
    }

    fun part2(input: String): String {
        val liste = splitString(input)
        val containsParts = getNumberOfPairsWithSectionsParlyOverlapping(liste)
        return containsParts
    }

    val input = readInput("input_Day04")

    println("Antall par hvor det dekker hverandres range fullstending (Del 1): " + part1(input))
    println("Antall par hvor det delvis dekker hverandres range (Del 2): " + part2(input))
}

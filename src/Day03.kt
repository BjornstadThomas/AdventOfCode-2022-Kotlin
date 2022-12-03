fun main() {



    fun getValueOfChar(char: Char): Int {


        return 1
    }

    fun checkForCommonChar(firstPart: String, secondPart: String): Char {


        return 'A'
    }


    fun splitString(input: String): String {
        val inputSplit = input.split("\r\n")
        val score = inputSplit
            .map {
                val mid = it.length / 2
                val part1 = it.substring(0, mid)
                val part2 = it.substring(mid)
                println("Del 1: " + part1)
                println("Del 2: " + part2)
                val common = checkForCommonChar(part1, part2)
                val value = getValueOfChar(common)
            }.toString()

        return score
    }


    fun part1(input: String): String {
        splitString(input)
        return "hei"
    }


    fun part2(input: String): String {

        return "hei"
    }

    val input = readInput("input_Day03")

    println("Mennesket scorer i Runde 1: " + part1(input))
//    println("Mennesket scorer i Runde 2: " + part2(input))
}

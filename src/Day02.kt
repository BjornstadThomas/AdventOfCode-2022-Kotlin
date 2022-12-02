fun main() {

    fun calcualteValueOfMove(input: String): Int {

        var AlvMove = 0
        var HumanMove = 0

//        println(input[0])

        when (input[0]) {
            'A' -> AlvMove = 1
            'B' -> AlvMove = 2
            'C' -> AlvMove = 3
        }

        when (input[2]) {
            'X' -> HumanMove = 1
            'Y' -> HumanMove = 2
            'Z' -> HumanMove = 3
        }

        println("Human: " + HumanMove)
        println("Alv: " + AlvMove)

        if (HumanMove > AlvMove) {
            return HumanMove + 6
        } else if (HumanMove == AlvMove)
            return HumanMove + 3
        else if (HumanMove < AlvMove)
            return HumanMove + 0

        return 999999
    }



    fun assignValueToMove(input: String): Int {
//        println(input) //Print input for å se opprinnelig liste
        var score = 0
        val inputSplit = input.split("\r\n")
        val iterator = inputSplit.iterator()
        iterator.forEach {
//            println("Element $it")
            score += calcualteValueOfMove(it)
            println("Score: " + score)

        }

/*
        val inputSplit2 = input.split("\r\n")
            .map{ it.lines()
                val score = it[0] + it[2].code
                println(score)
            }

        println(inputSplit2) //Print av sortert liste, descending*/
        return score
    }

    fun getThreeLargestValuesAndSumThemTogheter(calories: List<Int>): Int {
        val first = calories.get(0)
        val second = calories.get(1)
        val third = calories.get(2)
        println("Første: " + first).toString()
        println("Andre: " + second).toString()
        println("Tredje: " + third).toString()

        val sum = first + second + third
        return sum
    }


    fun part1(input: String): String {
        val inputSplit = input.split("\r\n")
        return inputSplit
            .map {
                when (it[0] to it[2]) {
                    'A' to 'X' -> 1 + 3
                    'A' to 'Y' -> 2 + 6
                    'A' to 'Z' -> 3 + 0
                    'B' to 'X' -> 1 + 0
                    'B' to 'Y' -> 2 + 3
                    'B' to 'Z' -> 3 + 6
                    'C' to 'X' -> 1 + 6
                    'C' to 'Y' -> 2 + 0
                    'C' to 'Z' -> 3 + 3
                    else -> 0
                }
            }.sum().toString()
    }

    fun part1_forLoop(input: String): String {
        return assignValueToMove(input).toString()
    }

    fun part2(input: String): String {
        val inputSplit = input.split("\r\n")
        return inputSplit
            .map {
                when (it[0] to it[2]) {
                    'A' to 'X' -> 3 + 0
                    'A' to 'Y' -> 1 + 3
                    'A' to 'Z' -> 2 + 6
                    'B' to 'X' -> 1 + 0
                    'B' to 'Y' -> 2 + 3
                    'B' to 'Z' -> 3 + 6
                    'C' to 'X' -> 2 + 0
                    'C' to 'Y' -> 3 + 3
                    'C' to 'Z' -> 1 + 6
                    else -> 0
                }
            }.sum().toString()
    }

    val input = readInput("input_Day02")

    println("Mennesket scorer i Runde 1: " + part1(input))
    println("Mennesket scorer i Runde 2: " + part2(input))
}

fun main() {



    fun getValueOfChar(char: Char): Int {
//        println(char)
        if (char.toInt() in 97..122)
            return char.toInt() - 96 //Fjerner 96 fra verdien, da ASCII for Liten bokstav, starter på 97 (a)
        else
            return char.toInt() - 38 //Fjerner kun 38, da ASCII for Stor bokstav, starter på 65 (A)
    }

    fun checkForCommonCharAndGetValue(firstPart: String, secondPart: String): Int {
        var commonChars = ' '

        for (i in 0 until firstPart.length) {
            for (j in 0 until secondPart.length) {
                if (firstPart[i] == secondPart[j]) {
                    commonChars = firstPart[i]
                }
            }
            if (commonChars.isLetter()) {
                return getValueOfChar(commonChars)
            }
        }
        println("Fant INGEN?!?!?!? i: " + firstPart + " | " + secondPart)

       return 0
    }

    fun checkForCommonCharInThreeStrings (input: List<String>): Char {
        return input
            .map { it.toSet() }
            .reduce { left, right -> left intersect right }
            .first()
    }


    fun splitString(input: String): String {
        val inputSplit = input.split("\r\n")
        var score = 0

        inputSplit
            .map {
                val mid = it.length / 2
                val part1 = it.substring(0, mid)
                val part2 = it.substring(mid)
//                println("Del 1: " + part1)
//                println("Del 2: " + part2)
                val valueOfChar = checkForCommonCharAndGetValue(part1, part2)
                score += valueOfChar
            }

        return score.toString()
    }

    fun splitStringPart2(input: String): String {
        val inputSplit = input.split("\r\n")
        var score = 0

        val chunked = inputSplit.chunked(3)
//        println(chunked)

        chunked.forEachIndexed { index, strings ->
//            println("Index $index med $strings ")
            val common = checkForCommonCharInThreeStrings(strings)
//            println("Common: " + common)
           score += getValueOfChar(common)
        }

        return score.toString()
    }


    fun part1(input: String): String {
        return splitString(input)
    }


    fun part2(input: String): String {
        return splitStringPart2(input)
    }

    val input = readInput("input_Day03")

    println("Sum av bokstaver (Del 1): " + part1(input))
    println("Sum av authentication-badge (Del 2): " + part2(input))
}

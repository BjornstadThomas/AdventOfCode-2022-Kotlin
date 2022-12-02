fun main() {
    fun groupCaloriesTogheter(input: String): List<Int> {
//        println(input) //Print input for å se opprinnelig liste
        val inputSplit = input.split("\r\n\r\n")
            .map{ it.lines()
                .map( String::toInt ).sum()}
                .sortedDescending()
//        println(inputSplit) //Print av sortert liste, descending
        return inputSplit
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
        return groupCaloriesTogheter(input).first().toString()
    }

    fun part2(input: String): String {
        val calories = groupCaloriesTogheter(input)
        return getThreeLargestValuesAndSumThemTogheter(calories).toString()
    }

    val input = readInput("input_Day01")

    println("Alven som bærer flest kalorier, bærer: " + part1(input))
    println("Sum av de tre alvene med mest kalorier: " + part2(input))
}

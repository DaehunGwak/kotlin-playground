package io.orid.cleancode.ch02meaningfulname

// page 35
fun main() {
    printGuessStatistics('B', 0u)
    printGuessStatistics('B', 1u)
    printGuessStatistics('B', 2u)

    val messageFactory = GuessStatisticsMessage()
    println(messageFactory.make('G', 0u))
    println(messageFactory.make('G', 1u))
    println(messageFactory.make('G', 2u))
}

// bad case
fun printGuessStatistics(
    candidate: Char,
    count: UInt,
) {
    val number: String
    val verb: String
    val pluralModifier: String
    when (count) {
        0u -> {
            number = "no"
            verb = "are"
            pluralModifier = "s"
        }
        1u -> {
            number = "1"
            verb = "is"
            pluralModifier = ""
        }
        else -> {
            number = "$count"
            verb = "are"
            pluralModifier = "s"
        }
    }
    println("There $verb $number $candidate$pluralModifier")
}

// good case
class GuessStatisticsMessage(
    private var number: String = "",
    private var verb: String = "",
    private var pluralModifier: String = "",
) {
    fun make(
        candidate: Char,
        count: UInt,
    ): String {
        createPluralDependentMessageParts(count)
        return "There $verb $number $candidate$pluralModifier"
    }

    private fun createPluralDependentMessageParts(count: UInt) {
        when (count) {
            0u -> thereAreNoLetters()
            1u -> thereIsOneLetter()
            else -> thereAreManyLetters(count)
        }
    }

    private fun thereAreNoLetters() {
        number = "no"
        verb = "are"
        pluralModifier = "s"
    }

    private fun thereIsOneLetter() {
        number = "1"
        verb = "is"
        pluralModifier = ""
    }

    private fun thereAreManyLetters(count: UInt) {
        number = "$count"
        verb = "are"
        pluralModifier = "s"
    }
}

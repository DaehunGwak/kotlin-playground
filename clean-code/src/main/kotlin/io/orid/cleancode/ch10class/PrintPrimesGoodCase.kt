package io.orid.cleancode.ch10class

import kotlin.math.min

/**
 * Clean Code p.181
 * good case
 */
fun main() {
    val NUMBER_OF_PRIMES = 1000
    val primes = PrimeGenerator.generate(NUMBER_OF_PRIMES)

    val ROWS_PER_PAGE = 50
    val COLUMNS_PER_PAGE = 4
    val tablePrinter = RowColumnPagePrinter(
        rowsPerPage = ROWS_PER_PAGE,
        columnsPerPage = COLUMNS_PER_PAGE,
        pageHeader = "The First $NUMBER_OF_PRIMES Prime Numbers"
    )
    tablePrinter.print(primes)

}

object PrimeGenerator {
    private lateinit var primes: Array<Int>
    private lateinit var multiplesOfPrimeFactors: ArrayList<Int>

    fun generate(n: Int): Array<Int> {
        primes = Array<Int>(n) { 0 }
        multiplesOfPrimeFactors = arrayListOf<Int>()
        set2AsFirstPrime()
        checkOddNumbersForSubsequentPrimes()
        return primes
    }

    private fun set2AsFirstPrime() {
        primes[0] = 2
        multiplesOfPrimeFactors.add(2)
    }

    private fun checkOddNumbersForSubsequentPrimes() {
        var primeIndex = 1
        for (candidate in 3..<primes.size step 2) {
            if (isPrime(candidate)) {
                primes[primeIndex++] = candidate
            }
        }
    }

    private fun isPrime(candidate: Int): Boolean {
        if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
            multiplesOfPrimeFactors.add(candidate)
            return false
        }
        return isNotMultipleOfAnyPreviousPrimeFactor(candidate)
    }

    private fun isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate: Int): Boolean {
        val nextLargerPrimeFactor = primes[multiplesOfPrimeFactors.size]
        val leastRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor
        return candidate == leastRelevantMultiple
    }

    private fun isNotMultipleOfAnyPreviousPrimeFactor(candidate: Int): Boolean {
        for (n in 1..<multiplesOfPrimeFactors.size) {
            if (isMultipleOfNthPrimeFactor(candidate, n)) {
                return false
            }
        }
        return true
    }

    private fun isMultipleOfNthPrimeFactor(candidate: Int, n: Int): Boolean {
        return candidate == smallestOddNthMultipleNotLessThanCandidate(candidate, n)
    }

    private fun smallestOddNthMultipleNotLessThanCandidate(candidate: Int, n: Int): Int {
        var multiple = multiplesOfPrimeFactors[n]
        while (multiple < candidate) {
            multiple += 2 * primes[n]
        }
        multiplesOfPrimeFactors[n] = multiple
        return multiple
    }
}

class RowColumnPagePrinter(
    private val rowsPerPage: Int,
    private val columnsPerPage: Int,
    private val pageHeader: String,
) {
    private val numbersPerPage = rowsPerPage * columnsPerPage

    fun print(data: Array<Int>) {
        var pageNumber = 1
        for (firstIndexOnPage in data.indices step numbersPerPage) {
            val lastIndexOnPage = min(firstIndexOnPage + numbersPerPage - 1, data.size - 1)
            printPageHeader(pageHeader, pageNumber)
            printPage(firstIndexOnPage, lastIndexOnPage, data)
            println("\u000c")
            pageNumber++
        }
    }

    private fun printPageHeader(pageHeader: String, pageNumber: Int) {
        println("$pageHeader --- Page $pageNumber")
        println("")
    }

    private fun printPage(firstIndexOnPage: Int, lastIndexOnPage: Int, data: Array<Int>) {
        for (firstIndexInRow in firstIndexOnPage..<firstIndexOnPage + rowsPerPage) {
            printRow(firstIndexInRow, lastIndexOnPage, data)
            println("")
        }
    }

    private fun printRow(firstIndexInRow: Int, lastIndexOnPage: Int, data: Array<Int>) {
        for (column in 0..<columnsPerPage) {
            val index = firstIndexInRow + column * rowsPerPage
            if (index <= lastIndexOnPage) {
                println(data[index].toString().padStart(10, ' '))
            }
        }
    }
}
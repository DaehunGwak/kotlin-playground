package io.orid.cleancode.ch10class

/**
 * Clean Code p.179
 * bad case
 */
fun main() {
    val M = 1000
    val RR = 50
    val CC = 4
    val WW = 10
    val ORDMAX = 30

    val P = Array<Int>(M + 1) { 0 }
    var PAGENUMBER: Int
    var PAGEOFFSET: Int
    var ROWOFFSET: Int
    var C: Int
    var J: Int
    var K: Int
    var JPRIME: Boolean
    var ORD: Int
    var SQUARE: Int
    var N: Int
    val MULT = Array<Int>(ORDMAX + 1) { 0 }

    J = 1
    K = 1
    P[1] = 2
    ORD = 2
    SQUARE = 9

    while (K < M) {
        do {
            J += 2
            if (J == SQUARE) {
                ORD++
                SQUARE = P[ORD] * P[ORD]
                MULT[ORD - 1] = J
            }
            N = 2
            JPRIME = true
            while (N < ORD && JPRIME) {
                while (MULT[N] < J) {
                    MULT[N] = MULT[N] + P[N] + P[N]
                }
                if (MULT[N] == J) {
                    JPRIME = false
                }
                N++
            }
        } while (!JPRIME)
        K++
        P[K] = J
    }

    PAGENUMBER = 1
    PAGEOFFSET = 1
    while (PAGEOFFSET <= M) {
        println("The First $M Prime Numbers --- Page $PAGENUMBER")
        println("")

        ROWOFFSET = PAGEOFFSET
        while (ROWOFFSET < PAGEOFFSET + RR) {
            for (C in 0..(CC - 1)) {
                if (ROWOFFSET + C * RR <= M) {
                    println(P[ROWOFFSET + C * RR].toString().padStart(10, ' '))
                }
            }
            println("")
            ROWOFFSET++
        }

        println("\u000c")
        PAGENUMBER++
        PAGEOFFSET += RR * CC
    }
}
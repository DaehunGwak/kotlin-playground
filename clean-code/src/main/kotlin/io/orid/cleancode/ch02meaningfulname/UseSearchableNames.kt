package io.orid.cleancode.ch02meaningfulname

import kotlin.random.Random

// page 29
fun main() {
    println(sumBad())
    println(sumRealTaskWeeks())
}

// bad case
val t = List(34) { Random.nextInt() }

fun sumBad(): Double {
    var s = 0.0
    for (j in t.indices) {
        s += t[j] * 4 / 5
    }
    return s
}

// good case
val taskEstimates = List(34) { Random.nextInt() }

var realDaysPerIdealDay = 4
const val WORK_DAYS_PER_WEEK = 5

fun sumRealTaskWeeks(): Double {
    var sum = 0.0
    for (j in taskEstimates.indices) {
        val realTaskDays = taskEstimates[j] * realDaysPerIdealDay
        val realTaskWeeks = realTaskDays / WORK_DAYS_PER_WEEK
        sum += realTaskWeeks
    }
    return sum
}

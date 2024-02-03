package io.orid.cleancode.ch02meaningfulname

import java.time.LocalDateTime

// page 28
// bad case
class DtaRcrd102(
    private var genymdhms: LocalDateTime,
    private var modymdhms: LocalDateTime,
    private val pszqint: String = "102",
)

// good case
class Customer(
    private var generationDateTime: LocalDateTime,
    private var modificationDateTime: LocalDateTime,
    private val recordId: String = "102",
)

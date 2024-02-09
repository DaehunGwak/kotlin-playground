package io.orid.cleancode.ch09unittest

class FitNesseRequest(
    var resource: String
) {
    constructor() : this("")

    fun addInput(type: String, target: String) {}
}

package io.orid.cleancode.ch09unittest

class Crawler {

    fun addPage(root: MockXml, parse: (root: MockXml) -> Unit): WikiPage {
        return WikiPage()
    }

    fun addPage(root: MockXml, parse: (root: MockXml) -> Unit, content: String): WikiPage {
        return WikiPage()
    }
}

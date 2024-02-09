package io.orid.cleancode.ch09unittest

class WikiPage(
    var data: PageData = PageData()
) {
    fun commit(data: PageData) {
        this.data = data
    }
}

class PageData(
    val properties: WikiPageProperties = WikiPageProperties()
)

class WikiPageProperties(
    private val pageTypeToProperty: MutableMap<SymbolicPage, WikiPageProperty> = mutableMapOf()
) {
    fun set(pageType: SymbolicPage): WikiPageProperty {
        val property = WikiPageProperty()
        pageTypeToProperty[pageType] = property
        return property
    }
}

class WikiPageProperty {
    fun set(parent: String, target: String) {}
}

enum class SymbolicPage {
    PROPERTY_NAME
}

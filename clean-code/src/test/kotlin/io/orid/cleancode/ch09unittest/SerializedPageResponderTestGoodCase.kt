package io.orid.cleancode.ch09unittest

import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Clean Code p.160
 *
 * good case
 * - 중복 코드 메소드 화
 * - 추상화 수준 동일하게 고려
 * -
 *
 * 참고: 사용된 객체들은 임의로 테스트 통과만 가능하도록 구성, 실제 기능과 무관
 */
class SerializedPageResponderTestGoodCase {
    private val crawler = Crawler()
    private val root = MockXml()

    @Test
    fun testGetPageHierarchyAsXml() {
        // given (BUILD)
        makePages("PageOne", "PageOne.ChildOne", "PageTwo")

        // when (OPERATE)
        val response = submitRequest("root", "type:pages")
        val xml = response.content

        // then (CHECK)
        assertResponseIsXml(response.contentType)
        assertResponseContains(
            xml, "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
        )
    }

    @Test
    fun testGetPageHierarchyAsXmlNotContainSymbolicLink() {
        val pageOne = makePage("PageOne")
        makePages("PageOne.ChildOne", "PageTwo")
        addLinkTo(pageOne, "SymPage", "PageTwo")

        val response = submitRequest("root", "type:pages")
        val xml = response.content

        assertResponseIsXml(response.contentType)
        assertResponseContains(
            xml, "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
        )
        assertResponseNotContain(xml, "SymPage")
    }

    @Test
    fun testGetDataHtml() {
        makePage("TestPageOne", "test page")

        val response = submitRequest("TestPageOne", "type:data")
        val xml = response.content

        assertResponseIsXml(response.contentType)
        assertResponseContains(xml, "test page", "<Test")
    }

    private fun makePages(vararg parsedTargets: String): List<WikiPage> {
        return parsedTargets.map { makePage(it) }
            .toList()
    }

    private fun makePage(parsedTarget: String): WikiPage {
        return crawler.addPage(root, PathParser.parse(parsedTarget))
    }

    private fun makePage(parsedTarget: String, content: String): WikiPage {
        return crawler.addPage(root, PathParser.parse(parsedTarget), content)
    }

    private fun addLinkTo(page: WikiPage, symParent: String, symTarget: String) {
        val data = page.data
        val properties = data.properties
        val symLinks = properties.set(SymbolicPage.PROPERTY_NAME)
        symLinks.set(symParent, symTarget)
        page.commit(data)
    }

    private fun submitRequest(resource: String, typeInput: String): SimpleResponse {
        val request = FitNesseRequest()
        request.resource = resource

        val typeInputs = typeInput.split(":")
        request.addInput(typeInputs[0], typeInputs[1])

        val responder = SerializedPageResponder()
        return responder.makeResponse(FitNesseContext(root), request)
    }

    private fun assertResponseIsXml(contentType: String) {
        assertEquals("text/xml", contentType)
    }

    private fun assertResponseContains(xml: String, vararg expects: String) {
        expects.forEach {
            assertContains(xml, it)
        }
    }

    private fun assertResponseNotContain(xml: String, expect: String) {
        assertFalse { xml.contains(expect) }
    }
}

package io.orid.cleancode.ch09unittest

import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Clean Code p.158
 *
 * bad case
 * - 이해가 어려움
 * - 중복이 많음
 * - 자질구레한 사항이 많아 표현력이 떨어진다.
 *
 * 참고: 사용된 객체들은 임의로 테스트 통과만 가능하도록 구성, 실제 기능과 무관
 */
class SerializedPageResponderTestBadCase {
    private val crawler = Crawler()
    private val root = MockXml()

    @Test
    fun testGetPageHierarchyAsXml() {
        crawler.addPage(root, PathParser.parse("PageOne"))
        crawler.addPage(root, PathParser.parse("PageOne.ChildOne"))
        crawler.addPage(root, PathParser.parse("PageTwo"))

        val request = FitNesseRequest()
        request.resource = "root"
        request.addInput("type", "pages")
        val responder = SerializedPageResponder()
        val response = responder.makeResponse(FitNesseContext(root), request)
        val xml = response.content

        assertEquals("text/xml", response.contentType)
        assertContains(xml, "<name>PageOne</name>")
        assertContains(xml, "<name>PageTwo</name>")
        assertContains(xml, "<name>ChildOne</name>")
    }

    @Test
    fun testGetPageHierarchyAsXmlNotContainSymbolicLink() {
        val pageOne = crawler.addPage(root, PathParser.parse("PageOne"))
        crawler.addPage(root, PathParser.parse("PageOne.ChildOne"))
        crawler.addPage(root, PathParser.parse("PageTwo"))

        val data = pageOne.data
        val properties = data.properties
        val symLinks = properties.set(SymbolicPage.PROPERTY_NAME)
        symLinks.set("SymPage", "PageTwo")
        pageOne.commit(data)

        val request = FitNesseRequest()
        request.resource = "root"
        request.addInput("type", "pages")
        val responder = SerializedPageResponder()
        val response = responder.makeResponse(FitNesseContext(root), request)
        val xml = response.content

        assertEquals("text/xml", response.contentType)
        assertContains(xml, "<name>PageOne</name>")
        assertContains(xml, "<name>PageTwo</name>")
        assertContains(xml, "<name>ChildOne</name>")
        assertFalse { xml.contains("SymPage") }
    }

    @Test
    fun testGetDataHtml() {
        crawler.addPage(root, PathParser.parse("TestPageOne"), "test page")

        val request = FitNesseRequest()
        request.resource = "TestPageOne"
        request.addInput("type", "data")
        val responder = SerializedPageResponder()
        val response = responder.makeResponse(FitNesseContext(root), request)
        val xml = response.content

        assertEquals("text/xml", response.contentType)
        assertContains(xml, "test page")
        assertContains(xml, "<Test")
    }
}

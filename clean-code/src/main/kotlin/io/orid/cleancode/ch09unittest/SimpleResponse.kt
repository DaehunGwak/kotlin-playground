package io.orid.cleancode.ch09unittest

data class SimpleResponse(
    val content: String = """
        <name>PageOne</name>
        <name>PageTwo</name>
        <name>ChildOne</name>
        <TestPageOne>test page</TestPageOne>
    """.trimIndent(),
    val contentType: String = "text/xml"
)

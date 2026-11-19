package com.coding.meet.util

import org.w3c.dom.Element
import org.w3c.dom.HTMLCollection
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.w3c.dom.asList

fun HTMLCollection.walk(onEach: (Element) -> Unit) {
    asList().forEach { child ->
        onEach(child)
        child.children.walk(onEach)
    }
}

fun NodeList.walk(onEach: (Node) -> Unit) {
    asList().forEach { node ->
        onEach(node)
        node.childNodes.walk(onEach)
    }
}

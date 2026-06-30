package builders.htmlbuilders

open class Tag(val name: String) {
    val children = mutableListOf<Tag>()
    val attributes = mutableListOf<Attribute>()

    override fun toString(): String {
        return "<$name" +
                (if (attributes.isEmpty()) "" else attributes.joinToString(separator = "", prefix = " ")) +
                ">" +
                (if (children.isEmpty()) "" else children.joinToString(separator = "")) +
                "</$name>"
    }
}

class Attribute(val name: String, val value: String) {
    override fun toString() = """$name="$value""""
}

fun <T : Tag> T.set(name: String, value: String?): T {
    if (value != null) {
        attributes.add(Attribute(name, value))
    }
    return this
}

fun <T : Tag> Tag.doInit(tag: T, init: T.() -> Unit): T {
    tag.init()
    children.add(tag)
    return tag
}

class Html : Tag("html") {
    fun table(init: Table.() -> Unit) = doInit(Table(), init)
}

class Table : Tag("table") {
    fun tr(color: String? = null, init: Tr.() -> Unit) = doInit(Tr(), init).set("bgcolor", color)
}

class Tr : Tag("tr") {
    fun td(color: String? = null, init: Td.() -> Unit) = doInit(Td(), init).set("bgcolor", color)
}

class Td : Tag("td")

fun Tag.text(s: Any?) {
    children.add(object : Tag("") {
        override fun toString() = s.toString()
    })
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}

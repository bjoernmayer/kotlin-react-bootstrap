package react.bootstrap.site.components.docs

import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.buildElements
import react.cloneElement
import react.dom.code
import react.dom.em
import react.dom.p
import react.dom.strong
import kotlin.browser.document

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"

internal fun RBuilder.classNamesImport() {
    ln { +"import react.bootstrap.lib.${ClassNames::class.simpleName}" }
}

internal fun RBuilder.ln(indentationLevel: Int = 0, block: RBuilder.() -> Unit) {
    for (x in 1..indentationLevel) {
        +"    "
    }
    block()
    +"\n"
}

internal fun RBuilder.formattedText(opener: Char = '<', closer: Char = '>', block: () -> String) {
    val text = block()

    p {
        text.split(opener).forEach { chunk ->
            if (!chunk.contains(closer)) {
                +chunk
            } else {
                wrapTags(
                    mapOf(
                        "|code".plus(closer) to code { },
                        "|strong".plus(closer) to strong { },
                        "|em".plus(closer) to em { }
                    ),
                    chunk
                )
            }
        }
    }
}

private fun RBuilder.wrapTags(wraps: Map<String, ReactElement>, target: String) {
    wraps.forEach { (tag, element) ->
        if (target.contains(tag)) {
            child(element {
                +target.substringBefore(tag)
            })

            +target.substringAfter(tag)
        }
    }
}

operator fun ReactElement.invoke(handler: RBuilder.() -> Unit): ReactElement =
    cloneElement(this, props, buildElements(handler))

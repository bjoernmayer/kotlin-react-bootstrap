package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.invoke
import react.dom.code
import react.dom.em
import react.dom.p
import react.dom.strong
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.document

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"

internal abstract class DocumentationPage(private val category: Category<*>) :
    RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        switch {
            category.subCategories.forEach { subcategory ->
                route<RProps>(subcategory.link) {
                    subcategory.renderer.invoke(this)
                }
            }
            route(category.link) {
                redirect(props.location.pathname, category.subCategories.first().link)
            }
        }
    }
}

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

internal fun RBuilder.formattedText(block: () -> String) {
    val text = block()

    p {
        text.split("<").forEach { chunk ->
            if (!chunk.contains(">")) {
                +chunk
            } else {
                wrapTags(
                    mapOf(
                        "|code>" to code { },
                        "|strong>" to strong { },
                        "|em>" to em { }
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

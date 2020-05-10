package react.bootstrap.site.components.docs.content.code

import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText

internal class CodeBlocks : SectionComponent() {
    override val title: String = "Code blocks"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            In order to make <pre { }|code>s scrollable, you can set the <scrollable>-argument, which will set a
            max-height of 340px and provide a y-axis scrollbar.
        """.trimIndent()
        }
        liveExample {
            pre(scrollable = true) {
                +"""
package react.bootstrap.site.components.docs.content.code

import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ln

internal class CodeBlocks : SectionComponent() {
    override val title: String = "Code blocks"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            ""${'"'}
            In order to make <pre { }|code>s scrollable, you can set the <scrollable>-argument, which will set a
            max-height of 340px and provide a y-axis scrollbar.
        ""${'"'}.trimIndent()
        }
        liveExample {
            pre(scrollable = true) {
                +""${'"'}
                Code was here
                ""${'"'}.trimIndent()
            }
        }
        codeExample {
            import("content.pre")
            ln { }
            ktB(0, "pre", "scrollable" to "true") {
                ln(it) { +"// Kotlin Code was here" }
            }
        }
    }
}
                """.trimIndent()
            }
        }
        codeExample {
            import("content.pre")
            ln { }
            ktB(0, "pre", "scrollable" to "true") {
                ln(it) { +"// Kotlin Code was here" }
            }
        }
    }
}

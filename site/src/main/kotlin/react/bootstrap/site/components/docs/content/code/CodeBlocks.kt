package react.bootstrap.site.components.docs.content.code

import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall

internal class CodeBlocks : SectionComponent() {
    override val title: String = "Code blocks"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
In order to make `pre { }`s scrollable, you can set the `scrollable`-argument, which will set a max-height of 340px and
provide a y-axis scrollbar.
            """
        }
        liveExample {
            pre(scrollable = true) {
                //language=Kotlin
                +"""
package react.bootstrap.site.components.docs.content.code

import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown

internal class CodeBlocks : SectionComponent() {
    override val title: String = "Code blocks"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +""${'"'}
In order to make `pre { }`s scrollable, you can set the `scrollable`-argument, which will set a max-height of 340px and
provide a y-axis scrollbar.
            ""${'"'}
        }
        liveExample {
            pre(scrollable = true) {
                +""${'"'}
// Code was here
                ""${'"'}.trimIndent()
            }
        }
        codeExample {
            import("content.pre")
            ln { }
            +FunCall.builder(RBuilder::pre)
                .addArgument("scrollable", true)
                .setLambdaArgument("// Kotlin Code was here")
                .build()
        }
    }
}
                """
            }
        }
        codeExample {
            addImport("content.pre")
            appendLine { }
            +FunCall.builder(RBuilder::pre)
                .addArgument("scrollable", true)
                .setLambdaArgument("// Kotlin Code was here")
                .build()
        }
    }
}

package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.P
import kotlinx.html.SMALL
import react.RBuilder
import react.bootstrap.content.typography.heading.h1
import react.bootstrap.content.typography.heading.h2
import react.bootstrap.content.typography.heading.h3
import react.bootstrap.content.typography.heading.h4
import react.bootstrap.content.typography.heading.h5
import react.bootstrap.content.typography.heading.h6
import react.bootstrap.content.typography.muted.muted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.h3
import react.dom.p

internal class Headings : SectionComponent() {
    override val title: String = "Headings"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Alternative implementation for `h1 { }` through `h6 { }` are provided, for when you want to match the font styling of a
heading but cannot use the associated HTML element.
            """
        }
        liveExample {
            h1<P> { +"h1. Bootstrap heading" }
            h2<P> { +"h2. Bootstrap heading" }
            h3<P> { +"h3. Bootstrap heading" }
            h4<P> { +"h4. Bootstrap heading" }
            h5<P> { +"h5. Bootstrap heading" }
            h6<P> { +"h6. Bootstrap heading" }
        }

        codeExample {
            +Imports.builder()
                .apply {
                    for (x in 1..6) {
                        addImport("content.typography.heading.h$x")
                    }
                }
                .build()
            repeat(6) {
                +FunCall.builder("h${it + 1}", FunCall.Style.NEW_INLINE)
                    .addTypeParameter(P::class)
                    .setLambdaArgument(plusString("h${it + 1}. Bootstrap heading"))
                    .build()
            }
        }
        subSectionTitle("Customizing headings", section)
        p {
            +"You can recreate the small secondary heading text from Bootstrap 3."
        }
        liveExample {
            h3 {
                +"Fancy display heading "
                muted<SMALL> { +"With faded secondary text" }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("content.typography.muted.muted")
                .build()

            +FunCall.builder("h3")
                .setLambdaArgument(
                    plusString("Fancy display heading "),
                    "\n",
                    FunCall.builder("muted", FunCall.Style.INLINE)
                        .addTypeParameter(SMALL::class)
                        .setLambdaArgument(plusString("With faded secondary text"))
                        .build()
                )
                .build()
        }
    }
}

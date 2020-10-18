package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.h1
import react.bootstrap.content.typography.h2
import react.bootstrap.content.typography.h3
import react.bootstrap.content.typography.h4
import react.bootstrap.content.typography.h5
import react.bootstrap.content.typography.h6
import react.bootstrap.content.typography.muted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6
import react.dom.p
import react.dom.small
import kotlin.reflect.KFunction3

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
            h1(RBuilder::p) { +"h1. Bootstrap heading" }
            h2(RBuilder::p) { +"h2. Bootstrap heading" }
            h3(RBuilder::p) { +"h3. Bootstrap heading" }
            h4(RBuilder::p) { +"h4. Bootstrap heading" }
            h5(RBuilder::p) { +"h5. Bootstrap heading" }
            h6(RBuilder::p) { +"h6. Bootstrap heading" }
        }

        codeExample {
            for (x in 1..6) {
                import("content.typography.h$x")
            }
            ln { }
            +listOf<KFunction3<*, *, *, *>>(
                RBuilder::h1,
                RBuilder::h2,
                RBuilder::h3,
                RBuilder::h4,
                RBuilder::h5,
                RBuilder::h6
            ).mapIndexed { index, function ->
                FunCall.builder(function, FunCall.Style.NEW_INLINE)
                    .addArgument(FunCall.Argument.PureValue("RBuilder::p"))
                    .setLambdaArgument(plusString("h${index + 1}. Bootstrap heading"))
                    .build()
            }.joinToString("")
        }
        subSectionTitle("Customizing headings", section)
        p {
            +"You can recreate the small secondary heading text from Bootstrap 3."
        }
        liveExample {
            h3 {
                +"Fancy display heading "
                muted(RBuilder::small) { +"With faded secondary text" }
            }
        }
        codeExample {
            import("content.typography.muted")
            ln { }
            val h3: KFunction3<*, *, *, *> = RBuilder::h3
            +FunCall.builder(h3)
                .setLambdaArgument(
                    plusString("Fancy display heading "),
                    "\n",
                    FunCall.builder("muted", FunCall.Style.INLINE)
                        .addArgument(FunCall.Argument.PureValue("RBuilder::small"))
                        .setLambdaArgument(plusString("With faded secondary text"))
                        .build()
                )
                .build()
        }
    }
}

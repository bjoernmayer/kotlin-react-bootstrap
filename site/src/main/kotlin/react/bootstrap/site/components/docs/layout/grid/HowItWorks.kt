@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.dom.a
import react.dom.p
import react.dom.strong

internal class HowItWorks : SectionComponent() {
    override val title: String = "How it works"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
Bootstrap’s grid system uses a series of containers, rows, and columns to layout and align content. It’s built with
flexbox and is fully responsive. Below is an example and an in-depth look at how the grid comes together.
            """
        }
        p {
            val link = "https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background"
            strong { +"New to or unfamiliar with flexbox? " }; a(href = link) { +"Read this CSS Tricks flexbox guide" }
            +"  for background, terminology, guidelines, and code snippets."
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        for (x in 1..3) {
                            col(sm = EQ) {
                                +"One of three columns"
                            }
                        }
                    }
                }
            }
        }
        codeExample {
            importFromGrid("col", EQ.import)
            importColFun()
            importContainerFun()
            importRowFun()
            appendLine { }
            +FunCall.builder(RBuilder::container)
                .setLambdaArgument(
                    FunCall.builder(RBuilder::row)
                        .setLambdaArgument(
                            buildString {
                                for (x in 1..3) {
                                    append(
                                        FunCall.builder(RBuilder::col)
                                            .addArgument("sm", FunCall.Argument.PureValue(EQ::class.simpleName!!))
                                            .setLambdaArgument(plusString("One of three columns"))
                                            .build()
                                    )
                                }
                            }
                        )
                        .build()
                )
                .build()
        }
        Markdown {
            val renderedContainerFun = FunCall.builder(RBuilder::container, FunCall.Style.INLINE)
                .setEmptyLambdaArgument()
                .build()
            //language=Markdown
            +"""
The above example creates three equal-width columns on small, medium, large, and extra large devices using Bootstrap's
predefined grid classes. Those columns are centered in the page with the parent `$renderedContainerFun`.
            """
        }
        p {
            +"Be aware of the limitations and "
            a("https://github.com/philipwalton/flexbugs") { +"bugs around flexbox" }; +", like the "
            a("https://github.com/philipwalton/flexbugs#flexbug-9") {
                +"inability to use some HTML elements as flex containers"
            }; +"."
        }
    }
}

@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.ln
import react.dom.a
import react.dom.p
import react.dom.strong

internal class HowItWorks : SectionComponent() {
    override val title: String = "How it works"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
            Bootstrap’s grid system uses a series of containers, rows, and columns to layout and align content. It’s
            built with flexbox and is fully responsive. Below is an example and an in-depth look at how the grid comes
            together.
        """.trimIndent()
        }
        p {
            val link = "https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background"
            strong { +"New to or unfamiliar with flexbox? " }; a(href = link) { +"Read this CSS Tricks flexbox guide" }
            +"  for background, terminology, guidelines, and code snippets."
        }
        exampleRow {
            example {
                container {
                    row {
                        for (x in 1..3) {
                            col(sm = Sizes.EQ) {
                                +"One of three columns"
                            }
                        }
                    }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(Sizes::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktConRow { il ->
                for (x in 1..3) {
                    ktBlock(il, "$colFun(sm = ${Sizes.EQ.kt})") { il ->
                        ln(il) { +"+\"One of three columns\"" }
                    }
                }
            }
        }
        formattedText {
            """
            The above example creates three equal-width columns on small, medium, large, and extra large devices using
            Bootstrap's predefined grid classes. Those columns are centered in the page with the parent <$containerFun
            { }|code>.
        """.trimIndent()
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

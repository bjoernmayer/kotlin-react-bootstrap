package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.RowFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.a
import react.dom.br
import react.dom.code
import react.dom.p
import react.dom.strong

fun RBuilder.howItWorks() {
    contentTitle { +"How it works" }
    p {
        +"Bootstrap’s grid system uses a series of containers, rows, and columns to layout and align content. It’s "
        +"built with flexbox and is fully responsive. Below is an example and an in-depth look at how the grid "
        +"comes together."
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
    val rowFun: RowFun = RBuilder::row
    val colFun: ColFun = RBuilder::col
    kotlinExample {
        +"${RBuilder::container.name} {"; br { }
        +"    ${rowFun.name} {"; br { }
        +"       ${colFun.name}(sm = ${Sizes::class.simpleName}.${Sizes.EQ.name}) {"; br { }
        +"           +\"One of three columns\""; br { }
        +"       }"; br { }
        +"       ${colFun.name}(sm = ${Sizes::class.simpleName}.${Sizes.EQ.name}) {"; br { }
        +"           +\"One of three columns\""; br { }
        +"       }"; br { }
        +"       ${colFun.name}(sm = ${Sizes::class.simpleName}.${Sizes.EQ.name}) {"; br { }
        +"           +\"One of three columns\""; br { }
        +"       }"; br { }
        +"    }"; br { }
        +"}"; br { }
    }
    p {
        +"The above example creates three equal-width columns on small, medium, large, and extra large devices using "
        +"Bootstrap's predefined grid classes. Those columns are centered in the page with the parent "
        code { +"${RBuilder::container.name} { }" }; +"."
    }
    p {
        +"Be aware of the limitations and "
        a("https://github.com/philipwalton/flexbugs") {
            +"bugs around flexbox"
        }; +", like the "
        a("https://github.com/philipwalton/flexbugs#flexbug-9") {
            +"inability to use some HTML elements as flex containers"
        }; +"."
    }
}

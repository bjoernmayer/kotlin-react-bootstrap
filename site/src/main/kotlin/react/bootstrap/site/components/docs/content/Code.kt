package react.bootstrap.site.components.docs.content

import react.Fragment
import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.code
import react.dom.p

fun RBuilder.code() = Fragment {
    contentPageTitle("Code")
    contentPageLead {
        +"Documentation and examples for displaying inline and multiline blocks of code with Bootstrap."
    }
    contentTitle("Code blocks")
    p {
        +"In order to make "; code { +"pre { }" }; +"s scrollable, you can set the "; code { +"scrollable" }
        +"-argument, which will set a max-height of 340px and provide a y-axis scrollbar."
    }
    example {
        pre(scrollable = true) {
            ktBlock(
                0,
                "interface AttributePair<T1 : CombinedAttributes, T2 : CombinedAttributes> : CombinedAttributes"
            ) { il ->
                ln(il) { +"val first: T1" }
                ln(il) { +"val second: T2" }
                ln { }
                ln(1) { +"override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = listOf(" }
                ln(2) { +"first.getClassNames(breakpoints)," }
                ln(2) { +"second.getClassNames(breakpoints)" }
                ln(1) { +").flatten().toSet()" }
            }
            ln { }
            +"interface AttributeTriple<T1 : CombinedAttributes, T2 : CombinedAttributes, T3 : CombinedAttributes> :"
            ln { }
            ln(1) { +"AttributePair<T1, T2> {" }
            ln(1) { +"val third: T3" }
            ln { +"" }
            +"    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoi"
            ln { +"nts)" }
            ln(2) { +".toMutableList().apply { addAll(third.getClassNames(breakpoints)) }" }
            ln(2) { +".toSet()" }
            +"}"
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.pre" }
        ln { }
        ktBlock(0, "pre(scrollable = true)") { il ->
            ln(il) { +"// Kotlin Code was here" }
        }
    }
}

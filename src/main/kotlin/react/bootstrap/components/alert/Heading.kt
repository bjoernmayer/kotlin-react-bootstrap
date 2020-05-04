package react.bootstrap.components.alert

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import kotlinx.html.HTMLTag
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.content.typography.Headings
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6

fun <T : HTMLTag> RElementBuilder<Alert.Props>.heading(
    headings: Headings,
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement =
    tagFun(classes.appendClass(headings.className, ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h1(classes: String? = null, block: RDOMBuilder<H1>.() -> Unit): ReactElement =
    h1(classes.appendClass(ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h2(classes: String? = null, block: RDOMBuilder<H2>.() -> Unit): ReactElement =
    h2(classes.appendClass(ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h3(classes: String? = null, block: RDOMBuilder<H3>.() -> Unit): ReactElement =
    h3(classes.appendClass(ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h4(classes: String? = null, block: RDOMBuilder<H4>.() -> Unit): ReactElement =
    h4(classes.appendClass(ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h5(classes: String? = null, block: RDOMBuilder<H5>.() -> Unit): ReactElement =
    h5(classes.appendClass(ClassNames.ALERT_HEADING), block)

fun RElementBuilder<Alert.Props>.h6(classes: String? = null, block: RDOMBuilder<H6>.() -> Unit): ReactElement =
    h6(classes.appendClass(ClassNames.ALERT_HEADING), block)

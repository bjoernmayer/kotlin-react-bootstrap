@file:Suppress("unused")

package react.bootstrap.components.alert

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.content.typography.Headings
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.classNameWrapper
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6

/**
 * Adds [ClassNames.ALERT_HEADING] to the outer most [ReactElement] resulting from [block].
 */
fun RElementBuilder<Alert.Props>.heading(headings: Headings, block: ElementProvider): ReactElement =
    classNameWrapper(setOf(headings.className, ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h1] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h1(classes: String? = null, block: RDOMBuilder<H1>.() -> Unit): ReactElement =
    h1(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h2] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h2(classes: String? = null, block: RDOMBuilder<H2>.() -> Unit): ReactElement =
    h2(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h3] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h3(classes: String? = null, block: RDOMBuilder<H3>.() -> Unit): ReactElement =
    h3(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h4] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h4(classes: String? = null, block: RDOMBuilder<H4>.() -> Unit): ReactElement =
    h4(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h5] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h5(classes: String? = null, block: RDOMBuilder<H5>.() -> Unit): ReactElement =
    h5(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom $alertName[h6] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h6(classes: String? = null, block: RDOMBuilder<H6>.() -> Unit): ReactElement =
    h6(classes.appendClass(ClassNames.ALERT_HEADING), block)

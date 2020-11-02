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
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.classNameWrapper
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6

/**
 * Notes:
 * As soon as Kotlin supports default type values, those methods can be made generic.
 */

/**
 * Adds [ClassNames.ALERT_HEADING] to the outer most [ReactElement] resulting from [block].
 */
fun RElementBuilder<Alert.Props>.heading(headings: Headings, block: ElementProvider): ReactElement =
    classNameWrapper(setOf(headings.className, ClassNames.ALERT_HEADING), block)

/**
 * Custom [h1] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h1(classes: String? = null, block: RDOMHandler<H1>): ReactElement =
    h1(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom [h2] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h2(classes: String? = null, block: RDOMHandler<H2>): ReactElement =
    h2(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom [h3] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h3(classes: String? = null, block: RDOMHandler<H3>): ReactElement =
    h3(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom [h4] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h4(classes: String? = null, block: RDOMHandler<H4>): ReactElement =
    h4(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom [h5] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h5(classes: String? = null, block: RDOMHandler<H5>): ReactElement =
    h5(classes.appendClass(ClassNames.ALERT_HEADING), block)

/**
 * Custom [h6] which behaves the same but adds [ClassNames.ALERT_HEADING] to classes.
 */
fun RElementBuilder<Alert.Props>.h6(classes: String? = null, block: RDOMHandler<H6>): ReactElement =
    h6(classes.appendClass(ClassNames.ALERT_HEADING), block)

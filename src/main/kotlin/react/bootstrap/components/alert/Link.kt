package react.bootstrap.components.alert

import react.RElementBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.classNameWrapper

/**
 * Adds [ClassNames.ALERT_LINK] to the outer most [ReactElement] resulting from [block].
 */
fun RElementBuilder<Alert.Props>.link(block: ElementProvider): ReactElement =
    classNameWrapper(setOf(ClassNames.ALERT_LINK), block)

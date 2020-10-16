package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.heading
import react.bootstrap.components.alert.link
import react.bootstrap.site.components.docs.buildNestedName
import kotlin.reflect.KClass
import kotlin.reflect.KType

internal val KClass<*>.nestedName: String
    get() = this.js.name.replace("$", ".")

internal val alertPropsName = Alert.Props::class.nestedName
internal val closingElementName = RElementBuilder<Alert.DismissibleProps>::closingElement.name
internal val headingName = RElementBuilder<Alert.Props>::heading.name
internal val linkName = RElementBuilder<Alert.Props>::link.name

internal val RBuilder.alertBuilderParents
    get() = listOf(RBuilder::Alerts.name)

internal val RBuilder.dismissibleAlertBuilderParents
    get() = listOf(RBuilder::Alerts.name, Alerts::dismissible.name)

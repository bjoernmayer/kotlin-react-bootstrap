package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.dismissibleAlert
import react.bootstrap.components.alert.heading
import react.bootstrap.components.alert.link
import kotlin.reflect.KClass

internal val KClass<out Alert.Variants>.nestedName: String
    get() = "${Alert::class.simpleName}.${this.simpleName}"

internal val KClass<out Alert.Props>.nestedName: String
    get() = "${Alert::class.simpleName}.${this.simpleName}"

internal val KClass<out Alert.DismissibleProps>.nestedName: String
    get() = "${Alert::class.simpleName}.${this.simpleName}"

internal val Alert.Variants.kt: String
    get() = "${this::class.nestedName}.$name"

internal val alertPropsName = Alert.Props::class.nestedName
internal val alertName = RBuilder::alert.name
internal val dismissibleAlertName = RBuilder::dismissibleAlert.name
internal val closingElementName = RElementBuilder<Alert.DismissibleProps>::closingElement.name
internal val headingName = RElementBuilder<Alert.Props>::heading.name
internal val linkName = RElementBuilder<Alert.Props>::link.name

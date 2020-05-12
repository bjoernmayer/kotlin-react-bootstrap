package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.dismissibleAlert
import react.bootstrap.components.alert.heading
import react.bootstrap.components.alert.link
import react.bootstrap.components.button.Button
import react.bootstrap.site.components.docs.buildNestedName
import kotlin.reflect.KClass

internal val KClass<out Alert.Variants>.nestedName: String
    get() = buildNestedName(this, Alert::class)

internal val KClass<out Alert.Props>.nestedName: String
    get() = buildNestedName(this, Alert::class)

internal val KClass<out Alert.DismissibleProps>.nestedName: String
    get() = buildNestedName(this, Alert::class)

internal val Alert.Variants.kt: String
    get() = buildNestedName(name, Alert::class, Button.Variants::class)

internal val alertPropsName = Alert.Props::class.nestedName
internal val alertName = RBuilder::alert.name
internal val dismissibleAlertName = RBuilder::dismissibleAlert.name
internal val closingElementName = RElementBuilder<Alert.DismissibleProps>::closingElement.name
internal val headingName = RElementBuilder<Alert.Props>::heading.name
internal val linkName = RElementBuilder<Alert.Props>::link.name

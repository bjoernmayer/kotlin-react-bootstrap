package react.bootstrap.site.components.docs.components.alerts

import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.link

internal val closingElementName = RElementBuilder<Alert.Dismissible.Props>::closingElement.name
internal val linkName = RElementBuilder<Alert.Props>::link.name

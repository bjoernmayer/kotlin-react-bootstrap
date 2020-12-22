package react.bootstrap.components.alert

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

public fun interface AlertDOMHandler<T : HtmlBlockTag> : DOMHandler<T, Alert.DomBuilder<T>>

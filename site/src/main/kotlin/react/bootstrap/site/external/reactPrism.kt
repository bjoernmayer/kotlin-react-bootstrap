@file:JsModule("react-prism")
@file:JsNonModule

package react.bootstrap.site.external

import react.RClass
import react.dom.WithClassName

external interface PrismCodeProps : WithClassName {
    var component: String
}

external val PrismCode: RClass<PrismCodeProps>

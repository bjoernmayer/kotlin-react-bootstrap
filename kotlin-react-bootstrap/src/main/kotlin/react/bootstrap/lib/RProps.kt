package react.bootstrap.lib

import kotlinext.js.Object
import kotlinext.js.jsObject
import kotlinx.html.HTMLTag
import react.RHandler
import react.RProps
import kotlin.reflect.KClass

interface WithTypeFlag<T : Any> : RProps {
    var krbType: KClass<T>
}

interface WithRDOMHandler<T : HTMLTag> : RProps {
    var handler: RDOMHandler<T>
}

interface WithRHandlerBlock<T : RProps> : RProps {
    var handler: RHandler<T>
}

interface WithActive : RProps {
    var active: Boolean?
    var onActive: NoArgEventHandler?
}

interface WithAriaLabel : RProps {
    var ariaLabel: String?
}

interface WithAriaDisabled : RProps {
    var ariaDisabled: Boolean?
}

interface WithRenderAs : RProps {
    var renderAs: ElementProvider?
}

interface WithDisabled : RProps {
    var disabled: Boolean?
}

/**
 * @return a mutable copy
 */
fun <T : RProps> T.toMutable(): T = Object.assign(jsObject(), this)

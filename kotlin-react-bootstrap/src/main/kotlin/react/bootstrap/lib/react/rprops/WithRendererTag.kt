package react.bootstrap.lib.react.rprops

import kotlinx.html.Tag
import react.RProps
import kotlin.reflect.KClass

interface WithRendererTag<TT : Tag> : WithGlobalAttributes {
    var rendererTag: KClass<out TT>?
}

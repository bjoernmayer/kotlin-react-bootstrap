package react.bootstrap.lib.react.rprops

import kotlinx.html.CommonAttributeGroupFacade
import kotlin.reflect.KClass

interface WithRendererTag<TT : CommonAttributeGroupFacade> : WithGlobalAttributes {
    var rendererTag: KClass<out TT>?
}

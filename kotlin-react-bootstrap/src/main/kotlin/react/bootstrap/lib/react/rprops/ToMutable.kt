package react.bootstrap.lib.react.rprops

import kotlinext.js.Object
import kotlinext.js.jsObject
import react.RProps

/**
 * @return a mutable copy
 */
public fun <T : RProps> T.toMutable(): T = Object.assign(jsObject(), this)

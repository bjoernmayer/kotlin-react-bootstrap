package react.bootstrap.lib.react.rprops

import react.RProps
import kotlin.reflect.KProperty0

fun RProps.requireProperties(property: KProperty0<*>, vararg properties: KProperty0<*>) {
    listOf(property, *properties).forEach {
        require(it.get() != null) {
            "Missing property: ${it.name} must not be null!"
        }
    }
}

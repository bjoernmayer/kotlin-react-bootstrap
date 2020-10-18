package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.layout.grid.importFromGrid
import kotlin.reflect.KClass

internal val KClass<Container.Viscosities>.nestedName: String
    get() = buildNestedName(this, Container::class)

internal fun CodeExampleBuilder.ktContainer(block: CodeExampleBuilder.() -> Unit) {
    ktFun(RBuilder::container) {
        block()
    }
}

internal fun CodeExampleBuilder.importContainerFun() {
    importFromGrid("container", RBuilder::container.name)
}

internal fun CodeExampleBuilder.importContainer() {
    import("layout.${Container::class.simpleName}")
}

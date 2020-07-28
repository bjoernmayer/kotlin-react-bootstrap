package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.layout.grid.importFromGrid
import kotlin.reflect.KClass

internal val RBuilder.containerFun: String
    get() = RBuilder::container.name

internal val Container.Viscosities.ktN: String
    get() = buildNestedName(name, Container::class, this::class)

internal val KClass<Container.Viscosities>.nestedName: String
    get() = buildNestedName(this, Container::class)

internal fun CodeExampleBuilder.ktContainer(block: CodeExampleBuilder.() -> Unit) {
    ktBlock(opener = containerFun) {
        block()
    }
}

internal fun CodeExampleBuilder.importContainerFun() {
    importFromGrid("container", containerFun)
}

internal fun CodeExampleBuilder.importContainer() {
    import("layout.${Container::class.simpleName}")
}

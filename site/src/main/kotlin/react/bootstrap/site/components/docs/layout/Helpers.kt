package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.bootstrap.layout.Container
import react.bootstrap.layout.container
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import kotlin.reflect.KClass

internal val RBuilder.containerFun: String
    get() = RBuilder::container.name

internal val Container.Viscosities.ktN: String
    get() = buildNestedName(name, Container::class, this::class)

internal val KClass<Container.Viscosities>.nestedName: String
    get() = buildNestedName(this, Container::class)

internal fun CodeExampleBuilder.ktContainer(block: CodeExampleBuilder.(indentationLevel: Int) -> Unit) {
    ktB(opener = containerFun) {
        block(1)
    }
}

internal fun CodeExampleBuilder.gridImport(className: String) {
    import("layout.grid.$className")
}

internal fun CodeExampleBuilder.importContainerFun() {
    gridImport(containerFun)
}

internal fun CodeExampleBuilder.importContainer() {
    import("layout.${Container::class.simpleName}")
}

package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.layout.grid.importFromGrid

internal val RBuilder.containerFun: String
    get() = RBuilder::container.name

internal val Container.Viscosities.ktN: String
    get() = "${Container::class.simpleName}.${Container.Viscosities::class.simpleName}.$name"

internal fun CodeExampleBuilder.ktContainer(block: CodeExampleBuilder.(indentationLevel: Int) -> Unit) {
    ktB(opener = containerFun) {
        block(1)
    }
}

internal fun CodeExampleBuilder.importContainerFun() {
    importFromGrid("container", containerFun)
}

internal fun CodeExampleBuilder.importContainer() {
    import("layout.${Container::class.simpleName}")
}

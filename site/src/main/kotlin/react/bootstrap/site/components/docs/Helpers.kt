package react.bootstrap.site.components.docs

import kotlinx.browser.document
import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.components.navs.navLinkBuilderFun
import react.bootstrap.site.lib.codepoet.Imports
import kotlin.reflect.KClass

internal val KClass<*>.nestedName: String
    get() = this.js.name.replace("$", ".")

internal val Enum<*>.nestedName: String
    get() = this::class.nestedName + ".$name"

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal fun Imports.importColFun() =
    importFromGrid("col", RBuilder::col.name)

internal fun Imports.importRowFun() =
    importFromGrid("row", RBuilder::row.name)

internal fun Imports.importFromGrid(`package`: String, className: String) =
    addImport("layout.grid.${`package`}.$className")

internal fun Imports.importContainerFun() =
    importFromGrid("container", RBuilder::container.name)

internal fun Imports.importContainer() =
    addImport("layout.${Container::class.simpleName}")

internal fun Imports.importButtonsBuilder() =
    addImport("components", "button", RBuilder::Buttons.name)

internal fun Imports.importButtonGroup() =
    addImport("components", "button", ButtonGroup::class.simpleName!!)

internal fun Imports.importButtonGroupBuilder() =
    addImport("components", "button", RBuilder::buttonGroup.name)

internal fun Imports.importButton() =
    addImport("components", "button", Button::class.simpleName!!)

internal fun Imports.importNavsBuilder() =
    addImport("components", "nav", RBuilder::Navs.name)

internal fun Imports.importNavItemBuilder() =
    addImport("components", "nav", RElementBuilder<NavComponent.Ul.Props>::navItem.name)

internal fun Imports.importNavLinkBuilder() =
    addImport("components", "nav", navLinkBuilderFun.name)

internal fun Imports.importNavComponents() =
    importNavsBuilder()
        .importNavItemBuilder()
        .importNavLinkBuilder()

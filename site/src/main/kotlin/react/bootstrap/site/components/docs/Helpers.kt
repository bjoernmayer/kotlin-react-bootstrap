package react.bootstrap.site.components.docs

import kotlinx.browser.document
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
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
    addImport(listOf("components", "button", RBuilder::Buttons.name).joinToString("."))

internal fun Imports.importButtonGroup() =
    addImport(listOf("components", "button", ButtonGroup::class.simpleName!!).joinToString("."))

internal fun Imports.importButtonGroupBuilder() =
    addImport(listOf("components", "button", RBuilder::buttonGroup.name).joinToString("."))

internal fun Imports.importButton() =
    addImport(listOf("components", "button", Button::class.simpleName!!).joinToString("."))

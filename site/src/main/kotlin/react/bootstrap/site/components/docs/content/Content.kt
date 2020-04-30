package react.bootstrap.site.components.docs.content

import react.RBuilder
import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.DocumentationPage
import react.bootstrap.site.components.docs.content.tables.tables
import react.bootstrap.site.components.docs.content.typography.typography

internal val content = Category(
    "Content",
    "content",
    Content::class
).apply {
    // "Reboot", "reboot",
    addSubCategory("Typography", "typography", RBuilder::typography)
    addSubCategory("Code", "code", RBuilder::code)
//                addSubCategory("Images", "images")
    addSubCategory("Tables", "tables", RBuilder::tables)
//                addSubCategory("Figures", "figures")
}

internal class Content : DocumentationPage(content)

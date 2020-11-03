package react.bootstrap.site.components.docs.content

import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.content.code.Code
import react.bootstrap.site.components.docs.content.images.Images
import react.bootstrap.site.components.docs.content.reference.Reference
import react.bootstrap.site.components.docs.content.tables.Tables
import react.bootstrap.site.components.docs.content.typography.Typography
import react.bootstrap.site.components.docs.fixings.CategoryComponent

internal class Content : CategoryComponent() {
    companion object {
        val component = Category(
            "Content",
            "content",
            Content::class
        ).apply {
            // "Reboot", "reboot",
            addCategory("Typography", "typography", Typography::class)
            addCategory("Code", "code", Code::class)
            addCategory("Images", "images", Images::class)
            addCategory("Tables", "tables", Tables::class)
            addCategory("Figures", "figures", Figures::class)
            addCategory("Reference", "reference", Reference::class)
        }
    }
}

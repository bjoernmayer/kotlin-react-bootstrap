package react.bootstrap.site.components.docs

import react.bootstrap.site.MatchProps
import react.bootstrap.site.components.PATH_DOCS
import react.bootstrap.site.components.docs.fixings.PageComponent
import react.bootstrap.site.components.docs.fixings.CategoryComponent
import kotlin.reflect.KClass

internal data class Category(
    val name: String,
    val path: String,
    val component: KClass<out CategoryComponent>
) {
    data class Page(
        val category: Category,
        val name: String,
        val path: String,
        val renderer: KClass<out PageComponent>
    ) {
        val link = "$PATH_DOCS${category.path}/$path/"
        val matchProps = MatchProps(link, true)
    }

    val link = "$PATH_DOCS$path/"
    val matchProps = MatchProps(link)
    val pages: MutableList<Page> = mutableListOf()

    fun addCategory(
        name: String,
        path: String,
        renderer: KClass<out PageComponent>
    ) {
        pages.add(Page(this, name, path, renderer))
    }
}

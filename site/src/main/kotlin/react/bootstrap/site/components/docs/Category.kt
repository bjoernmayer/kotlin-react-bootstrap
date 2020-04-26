package react.bootstrap.site.components.docs

import react.RComponent
import react.RProps
import react.bootstrap.site.MatchProps
import react.bootstrap.site.components.PATH_DOCS
import react.router.dom.RouteResultProps
import kotlin.reflect.KClass

data class Category<T : RComponent<RouteResultProps<RProps>, *>>(
    val name: String,
    val path: String,
    val component: KClass<T>
) {
    data class SubCategory(
        val category: Category<*>,
        val name: String,
        val path: String
    ) {
        val link = "$PATH_DOCS${category.path}/$path/"
        val matchProps = MatchProps(link, true)
    }

    val link = "$PATH_DOCS$path/"
    val matchProps = MatchProps(link)
    val subCategories: MutableList<SubCategory> = mutableListOf()

    fun addSubCategory(name: String, path: String) {
        subCategories.add(SubCategory(this, name, path))
    }
}

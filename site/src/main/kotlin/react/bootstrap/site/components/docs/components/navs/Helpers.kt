package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import kotlin.reflect.KFunction7

internal val navsBuilderParents
    get() = listOf(RBuilder::Navs.name)

internal fun CodeExampleBuilder.importNavsBuilder() {
    import(buildNestedName(RBuilder::Navs.name, "components", "nav"))
}

internal fun CodeExampleBuilder.importNavItemBuilder() {
    import(buildNestedName(RElementBuilder<Navs.Ul.Props>::navItem.name, "components", "nav"))
}

internal val navItemBuilderFun = RElementBuilder<Navs.Ul.Props>::navItem
internal val navLinkBuilderFun: KFunction7<
    RElementBuilder<NavItems.Li.Props>, String?, String?, Boolean?, (() -> Unit)?, Boolean?,
    RElementBuilder<NavLink.Props>.() -> Unit, ReactElement> =
    RElementBuilder<NavItems.Li.Props>::navLink

internal fun CodeExampleBuilder.importNavLinkBuilder() {
    import(buildNestedName(navLinkBuilderFun.name, "components", "nav"))
}

package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.LI
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import react.RBuilder
import react.bootstrap.components.nav.ActiveLinkPredicate
import react.bootstrap.components.nav.NavDOMHandler
import react.bootstrap.components.nav.NavItemDOMHandler
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.Navigation
import react.bootstrap.components.nav.NavigationBuilder
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.h4

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
        listOf(
            Triple(NavigationBuilder::ul, Navigation.Ul.Props::class, UL::class),
            Triple(NavigationBuilder::ol, Navigation.Ol.Props::class, OL::class),
            Triple(NavigationBuilder::nav, Navigation.Nav.Props::class, NAV::class),
            Triple(NavigationBuilder::div, Navigation.Div.Props::class, DIV::class)
        ).forEach { (function, propKlazz, tagKlazz) ->
            subSectionTitle(function.name)
            Markdown {
                //language=Markdown
                +"""
Creates a `${function.name}`-based navigation.
                """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy<NavigationBuilder>()
                    .addParameter<String?>("classes", null)
                    .addParameter<Navigation.Appearance>("appearance", null)
                    .addParameter<Navigation.WidthHandling>("widthHandling", null)
                    .addParameter<ActiveLinkPredicate?>("activeLinkPredicate", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, propKlazz),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(NavDOMHandler::class, tagKlazz))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("navItem")
        listOf(
            Triple(Generic.builder<Navigation.DomBuilder<*>, UL>(), NavItems.Li.Props::class, NavItems.Li::class),
            Triple(Generic.builder<Navigation.DomBuilder<*>, OL>(), NavItems.Li.Props::class, NavItems.Li::class),
            Triple(
                Generic.builder<Navigation.DomBuilder<*>, NAV>(),
                NavItems.DivItem.Props::class,
                NavItems.DivItem::class
            ),
            Triple(
                Generic.builder<Navigation.DomBuilder<*>, DIV>(),
                NavItems.DivItem.Props::class,
                NavItems.DivItem::class
            ),
        ).forEach { (navDomBuilder, itemPropsKlazz, itemKlazz) ->
            h4 { +"${navDomBuilder.build()}.navItem" }
            Markdown {
                //language=Markdown
                +"""
Creates a `${itemKlazz.nestedName}` element.
                """
            }
            codeExample {
                +FunSpec.builder(Navigation.DomBuilder<UL>::navItem)
                    .nestedBy(navDomBuilder)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, itemPropsKlazz),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(NavItemDOMHandler::class, navDomBuilder.typeName))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("navLink")
        listOf(
            Generic.builder<Navigation.DomBuilder<*>, NAV>() to Navigation.DomBuilder<NAV>::navLink,
            Generic.builder<Navigation.DomBuilder<*>, DIV>() to Navigation.DomBuilder<DIV>::navLink,
            Generic.builder<NavItems.DomBuilder<*>, LI>() to NavItems.DomBuilder<LI>::navLink,
            Generic.builder<NavItems.DomBuilder<*>, DIV>() to NavItems.DomBuilder<DIV>::navLink
        ).forEach { (elementBuilderGeneric, function) ->
            h4 { +"${elementBuilderGeneric.build()}.navLink" }
            Markdown {
                //language=Markdown
                +"""
Creates a `${NavLink::class.nestedName}` element.
                """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy(elementBuilderGeneric)
                    .addParameter<String?>("href", null)
                    .addParameter<String?>("target", null)
                    .addParameter<String?>("classes", null)
                    .addParameter("active", false)
                    .addParameter("disabled", false)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, NavLink.Props::class),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic.builder<RDOMHandler<*>, A>())
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}

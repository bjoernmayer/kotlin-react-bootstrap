package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.LI
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import react.RBuilder
import react.bootstrap.components.nav.ActiveLinkPredicate
import react.bootstrap.components.nav.NavBuilder
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavDOMHandler
import react.bootstrap.components.nav.NavItemDOMHandler
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
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
            Triple(NavBuilder::ul, NavComponent.Ul.Props::class, UL::class),
            Triple(NavBuilder::ol, NavComponent.Ol.Props::class, OL::class),
            Triple(NavBuilder::nav, NavComponent.Nav.Props::class, NAV::class),
            Triple(NavBuilder::div, NavComponent.Div.Props::class, DIV::class)
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
                    .nestedBy<NavBuilder>()
                    .addParameter<String?>("classes", null)
                    .addParameter<NavComponent.Appearance>("appearance", null)
                    .addParameter<NavComponent.WidthHandling>("widthHandling", null)
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
            Triple(Generic.builder<NavComponent.DomBuilder<*>, UL>(), NavItems.Li.Props::class, NavItems.Li::class),
            Triple(Generic.builder<NavComponent.DomBuilder<*>, OL>(), NavItems.Li.Props::class, NavItems.Li::class),
            Triple(
                Generic.builder<NavComponent.DomBuilder<*>, NAV>(),
                NavItems.DivItem.Props::class,
                NavItems.DivItem::class
            ),
            Triple(
                Generic.builder<NavComponent.DomBuilder<*>, DIV>(),
                NavItems.DivItem.Props::class,
                NavItems.DivItem::class
            ),
        ).forEach { (navDomBuilder, itemPropsKlazz, itemKlazz) ->
            h4("bd-content-title") { +"${navDomBuilder.build()}.navItem" }
            Markdown {
                //language=Markdown
                +"""
Creates a `${itemKlazz.nestedName}` element.
                """
            }
            codeExample {
                +FunSpec.builder(NavComponent.DomBuilder<UL>::navItem)
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
            Generic.builder<NavComponent.DomBuilder<*>, NAV>() to NavComponent.DomBuilder<NAV>::navLink,
            Generic.builder<NavComponent.DomBuilder<*>, DIV>() to NavComponent.DomBuilder<DIV>::navLink,
            Generic.builder<NavItems.DomBuilder<*>, LI>() to NavItems.DomBuilder<LI>::navLink,
            Generic.builder<NavItems.DomBuilder<*>, DIV>() to NavItems.DomBuilder<DIV>::navLink
        ).forEach { (elementBuilderGeneric, function) ->
            h4("bd-content-title") { +"${elementBuilderGeneric.build()}.navLink" }
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
                    .addParameter<String?>("classes", null)
                    .addParameter<String?>("target", null)
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

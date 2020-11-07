package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.nav.NavBuilder
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.LambdaType
import react.dom.h4

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
        listOf(NavBuilder::ul, NavBuilder::ol, NavBuilder::nav, NavBuilder::div).forEach { function ->
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
                    .addParameter(
                        "activeLinkPredicate",
                        LambdaType.builder()
                            .addArgument(NavLink.Props::class)
                            .returns(Boolean::class),
                        true,
                        FunSpec.Parameter.NULL
                    )
                    .addParameter("block", Generic("RHandler", NavComponent.Ul.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("navItem")
        listOf(
            Triple(NavComponent.Ul.Props::class, NavItems.Li.Props::class, NavItems.Li::class),
            Triple(NavComponent.Ol.Props::class, NavItems.Li.Props::class, NavItems.Li::class),
            Triple(NavComponent.Nav.Props::class, NavItems.NavItem.Props::class, NavItems.NavItem::class),
            Triple(NavComponent.Div.Props::class, NavItems.DivItem.Props::class, NavItems.DivItem::class),
        ).forEach { (navPropsKlazz, itemPropsKlazz, itemKlazz) ->
            val elementBuilderGeneric = Generic("RElementBuilder", navPropsKlazz)
            contentTitle(RBuilder::h4, "${elementBuilderGeneric.build()}.navItem")
            Markdown {
                //language=Markdown
                +"""
Creates a `${itemKlazz.nestedName}` element.
                """
            }
            codeExample {
                +FunSpec.builder(RElementBuilder<NavComponent.Ul.Props>::navItem)
                    .nestedBy(elementBuilderGeneric)
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", itemPropsKlazz))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("navLink")
        listOf(
            RElementBuilder<NavItems.Li.Props>::navLink to NavItems.Li.Props::class,
            RElementBuilder<NavComponent.Nav.Props>::navLink to NavComponent.Nav.Props::class,
            RElementBuilder<NavItems.NavItem.Props>::navLink to NavItems.NavItem.Props::class,
            RElementBuilder<NavComponent.Div.Props>::navLink to NavComponent.Div.Props::class,
            RElementBuilder<NavItems.DivItem.Props>::navLink to NavItems.DivItem.Props::class,
        ).forEach { (function, propsKlazz) ->
            val elementBuilderGeneric = Generic("RElementBuilder", propsKlazz)
            contentTitle(RBuilder::h4, "${elementBuilderGeneric.build()}.navLink")
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
                    .addParameter("block", Generic("RHandler", NavLink.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}

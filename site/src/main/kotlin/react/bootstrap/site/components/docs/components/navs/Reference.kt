package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.components.nav.NavBuilder
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavLink
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.LambdaType

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle("Builder", section)
        Markdown {
            //language=Markdown
            +"""
Navs are creating using the `${NavBuilder::class.simpleName!!}`. It is available in `RBuilder` as extension val.
            """
        }
        codeExample {
            +"val react.RBuilder.Navs get() = NavBuilder(this)"
        }
        listOf(NavBuilder::ul, NavBuilder::ol, NavBuilder::nav, NavBuilder::div).forEach { function ->
            subSectionTitle("${NavBuilder::class.simpleName!!}.${function.name}", section)
            Markdown {
                //language=Markdown
                +"""
Creates a `${function.name}`-based navigation.
                """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy(NavBuilder::class)
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("appearance", NavComponent.Appearance::class, true, FunSpec.Parameter.NULL)
                    .addParameter("widthHandling", NavComponent.WidthHandling::class, true, FunSpec.Parameter.NULL)
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
    }
}

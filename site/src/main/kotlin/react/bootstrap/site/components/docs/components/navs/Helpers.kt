package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import kotlinx.html.LI
import kotlinx.html.UL
import react.ReactElement
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.PropHandler
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.lib.codepoet.FunCall
import react.dom.RDOMBuilder
import kotlin.reflect.KFunction8

internal val navItemBuilderFun = NavComponent.DomBuilder<UL>::navItem
internal val navLinkBuilderFun: KFunction8<
    NavItems.DomBuilder<LI>, String?, String?, String?, Boolean, Boolean, PropHandler<NavLink.Props>,
    RDOMBuilder<A>.() -> Unit, ReactElement> =
    NavItems.DomBuilder<LI>::navLink

internal fun CodeExampleBuilder.testingNavItemsString() =
    buildString {
        append(
            FunCall.builder(navItemBuilderFun)
                .setLambdaArgument(
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("active", true)
                        .setLambdaArgument(plusString("Active"))
                        .build()
                )
                .build()
        )
        repeat(2) {
            append(
                FunCall.builder(navItemBuilderFun)
                    .setLambdaArgument(
                        FunCall.builder(navLinkBuilderFun)
                            .addArgument("href", "#")
                            .setLambdaArgument(plusString("Link"))
                            .build()
                    )
                    .build()
            )
        }
        append(
            FunCall.builder(navItemBuilderFun)
                .setLambdaArgument(
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("disabled", true)
                        .setLambdaArgument(plusString("Disabled"))
                        .build()
                )
                .build()
        )
    }

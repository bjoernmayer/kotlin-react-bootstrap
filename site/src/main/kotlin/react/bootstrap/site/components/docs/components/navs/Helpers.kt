package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import kotlinx.html.LI
import kotlinx.html.UL
import react.ReactElement
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.Navigation
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.lib.codepoet.FunCall
import kotlin.reflect.KFunction8

internal val navItemBuilderFun = Navigation.DomBuilder<UL>::navItem
internal val navLinkBuilderFun: KFunction8<
    NavItems.DomBuilder<LI>, String?, String?, String?, Boolean, Boolean, PropHandler<NavLink.Props>,
    RDOMHandler<A>, ReactElement> =
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

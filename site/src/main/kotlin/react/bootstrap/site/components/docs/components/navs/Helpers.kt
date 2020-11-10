package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.lib.codepoet.FunCall
import react.dom.RDOMBuilder
import kotlin.reflect.KFunction7

internal val navItemBuilderFun = RElementBuilder<NavComponent.Ul.Props>::navItem
internal val navLinkBuilderFun: KFunction7<
    RElementBuilder<NavItems.Li.Props>, String?, String?, String?, Boolean, Boolean,
    RDOMBuilder<A>.() -> Unit, ReactElement> =
    RElementBuilder<NavItems.Li.Props>::navLink

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

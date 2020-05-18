package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.external.PrismLight
import react.dom.figure
import kotlin.reflect.KFunction

internal typealias CodeExampleBuilder = RElementBuilder<CodeExample.Props>

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/styles/prism/coy")
external val coy: dynamic

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/languages/prism/kotlin")
external val kotlin: dynamic

private fun getIndent(indentationLevel: Int): String {
    val indentBuilder = StringBuilder()

    for (x in 1..indentationLevel) {
        indentBuilder.append("    ")
    }

    return indentBuilder.toString()
}

internal fun CodeExampleBuilder.ln(indentationLevel: Int = 0, block: CodeExampleBuilder.() -> Unit) {
    +getIndent(indentationLevel)
    block()
    +"\n"
}

internal fun CodeExampleBuilder.import(afterReactBootstrap: String) {
    ln { +"import react.bootstrap.$afterReactBootstrap" }
}

internal fun CodeExampleBuilder.importClassNames() {
    import("lib.${ClassNames::class.simpleName}")
}

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) {
    ln(indentationLevel) { +"$opener {" }
    block(indentationLevel + 1)
    ln(indentationLevel) { +"}" }
}

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    args: String,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktB(indentationLevel, "$opener($args)", block)

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktB(indentationLevel, opener, args.joinToString { "${it.first} = ${it.second}" }, block)

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    breakDownArgs: Boolean = false,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) {
    val (separator, fix, valuePrefix) = if (breakDownArgs) {
        Triple(",\n", "\n", getIndent(indentationLevel + 1))
    } else {
        Triple(", ", "", "")
    }

    ktB(
        indentationLevel,
        opener,
        args.joinToString(separator, fix, fix) { "$valuePrefix${it.first} = ${it.second}" },
        block
    )
}

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: KFunction<*>,
    breakDownArgs: Boolean = false,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktB(
    indentationLevel = indentationLevel,
    opener = opener.name,
    breakDownArgs = breakDownArgs,
    block = block,
    args = *args
)

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    content: String
) {
    if (content.isEmpty()) {
        ln(indentationLevel) { +"$opener { }" }
    } else {
        ln(indentationLevel) { +"$opener { $content }" }
    }
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    content: () -> String
) {
    ln(indentationLevel) { +"$opener { ${content()} }" }
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    args: String,
    content: String
) {
    ktIB(indentationLevel, "$opener($args)", content)
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: KFunction<*>,
    args: String,
    content: String
) {
    ktIB(indentationLevel, "${opener.name}($args)", content)
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    arg: Pair<String, String>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIB(indentationLevel, opener, listOf(arg, *args).joinToString { "${it.first} = ${it.second}" }, content())

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    arg: Pair<String, String>,
    vararg args: Pair<String, String>
) = ktIB(
    indentationLevel,
    opener,
    arg,
    *args
) { "+\"${listOf(arg, *args).joinToString { "${it.first} = ${it.second}" }}\"" }

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    breakDownArgs: Boolean = false,
    arg: Pair<String, String>,
    vararg args: Pair<String, Any>,
    content: () -> String
) {
    val (separator, fix, valuePrefix) = if (breakDownArgs) {
        Triple(",\n", "\n", getIndent(indentationLevel + 1))
    } else {
        Triple(", ", "", "")
    }

    ktIB(
        indentationLevel,
        opener,
        listOf(arg, *args).joinToString(separator, fix, fix) { "$valuePrefix${it.first} = ${it.second}" },
        content()
    )
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: KFunction<*>,
    arg: Pair<String, String>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIB(indentationLevel = indentationLevel, opener = opener.name, content = content, arg = arg, args = *args)

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: KFunction<*>,
    breakDownArgs: Boolean = false,
    arg: Pair<String, String>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIB(
    indentationLevel = indentationLevel,
    opener = opener.name,
    breakDownArgs = breakDownArgs,
    content = content,
    arg = arg,
    args = *args
)

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: KFunction<*>,
    arg: Pair<String, String>,
    vararg args: Pair<String, Any>
) = ktIB(indentationLevel = indentationLevel, opener = opener.name, arg = arg, args = *args)

internal class CodeExample : RComponent<CodeExample.Props, RState>() {
    override fun RBuilder.render() {
        val code = props.code ?: ""

        PrismLight.registerLanguage("kotlin", kotlin.default)

        figure("highlight") {
            PrismLight {
                attrs {
                    language = "kotlin"
                    style = coy.default
                }
                +code
            }
        }
    }

    interface Props : RProps {
        var code: String?
    }
}

internal fun RBuilder.codeExample(block: RHandler<CodeExample.Props>): ReactElement {
    val code = CodeExampleBuilder(jsObject()).apply {
        block()
    }

    return child(CodeExample::class) {
        attrs.code = code.childList.joinToString("")
    }
}

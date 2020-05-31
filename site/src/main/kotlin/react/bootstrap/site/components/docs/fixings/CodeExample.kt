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

private fun getIndent(indentation: Int): String {
    val indentBuilder = StringBuilder()

    for (x in 1..indentation) {
        indentBuilder.append("    ")
    }

    return indentBuilder.toString()
}

internal fun CodeExampleBuilder.ln(indentation: Int = 0, block: CodeExampleBuilder.() -> Unit) {
    +getIndent(indentation)
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
    indentation: Int = 0,
    opener: String,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) {
    ln(indentation) { +"$opener {" }
    block(indentation + 1)
    ln(indentation) { +"}" }
}

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    function: KFunction<*>,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) = ktB(indentation, function.name, block)

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    functionName: String,
    argString: String,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) = ktB(indentation, "$functionName($argString)", block)

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    function: KFunction<*>,
    argString: String,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) = ktF(indentation, function.name, argString, block)

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    functionName: String,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) = ktF(indentation, functionName, listOf(arg, *args).joinToString { "${it.first} = ${it.second}" }, block)

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    function: KFunction<*>,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) = ktF(indentation = indentation, functionName = function.name, arg = arg, block = block, args = *args)

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    functionName: String,
    breakDownArgs: Boolean = false,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentation: Int) -> Unit
) {
    val (separator, fix, valuePrefix) = if (breakDownArgs) {
        Triple(",\n", "\n", getIndent(indentation + 1))
    } else {
        Triple(", ", "", "")
    }

    ktF(
        indentation,
        functionName,
        listOf(arg, *args).joinToString(separator, fix, fix) { "$valuePrefix${it.first} = ${it.second}" },
        block
    )
}

internal fun CodeExampleBuilder.ktF(
    indentation: Int = 0,
    function: KFunction<*>,
    breakDownArgs: Boolean = false,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktF(
    indentation = indentation,
    functionName = function.name,
    breakDownArgs = breakDownArgs,
    arg = arg,
    block = block,
    args = *args
)

internal fun CodeExampleBuilder.ktIB(
    indentation: Int = 0,
    opener: String,
    content: String
) {
    if (content.isEmpty()) {
        ln(indentation) { +"$opener { }" }
    } else {
        ln(indentation) { +"$opener { $content }" }
    }
}

internal fun CodeExampleBuilder.ktIB(
    indentation: Int = 0,
    opener: String,
    content: () -> String
) = ktIB(indentation, opener, content())

internal fun CodeExampleBuilder.ktNestedInlineFun(
    indentation: Int = 0,
    function: KFunction<*>,
    parents: List<String>,
    content: () -> String
) = ktIB(indentation, "${parents.joinToString(".")}.${function.name}", content)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    content: String
) = ktIB(indentation, function.name, content)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    content: () -> String
) = ktIB(indentation, function.name, content)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    functionName: String,
    argString: String,
    content: String
) = ktIB(indentation, "$functionName($argString)", content)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    argString: String,
    content: String
) = ktIF(indentation, function.name, argString, content)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    functionName: String,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIF(
    indentation,
    functionName,
    listOf(arg, *args).joinToString { "${it.first} = ${it.second}" },
    content()
)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    functionName: String,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>
) = ktIF(indentation, functionName, arg, *args) {
    "+\"${listOf(arg, *args).joinToString { "${it.first} = ${it.second}" }}\""
}

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>
) = ktIF(indentation = indentation, functionName = function.name, arg = arg, args = *args)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    functionName: String,
    breakDownArgs: Boolean = false,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    content: () -> String
) {
    val (separator, fix, valuePrefix) = if (breakDownArgs) {
        Triple(",\n", "\n", getIndent(indentation + 1))
    } else {
        Triple(", ", "", "")
    }

    ktIF(
        indentation,
        functionName,
        listOf(arg, *args).joinToString(separator, fix, fix) { "$valuePrefix${it.first} = ${it.second}" },
        content()
    )
}

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIF(
    indentation = indentation,
    functionName = function.name,
    content = content,
    arg = arg,
    args = *args
)

internal fun CodeExampleBuilder.ktIF(
    indentation: Int = 0,
    function: KFunction<*>,
    breakDownArgs: Boolean = false,
    arg: Pair<String, Any>,
    vararg args: Pair<String, Any>,
    content: () -> String
) = ktIF(
    indentation = indentation,
    functionName = function.name,
    breakDownArgs = breakDownArgs,
    content = content,
    arg = arg,
    args = *args
)

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

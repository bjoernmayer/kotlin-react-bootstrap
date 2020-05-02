@file:JsModule("react-syntax-highlighter")
@file:JsNonModule
@file:Suppress("unused")

package react.bootstrap.site.external

import react.RClass
import react.RProps
import react.ReactElement

external interface ReactSyntaxHighlighterProps : RProps {
    var language: String?
    var style: dynamic
    var useInlineStyles: Boolean?
    var showLineNumbers: Boolean?
    var showInlineLineNumbers: Boolean?
    var startingLineNumber: Int?
    var lineNumberContainerStyle: String?
    var lineNumberStyle: String?
    var wrapLines: Boolean?
    var lineProps: ((currentLineNumber: Int) -> RProps)?
    var preTag: ReactElement?
    var codeTag: ReactElement?
}

external interface SyntaxHighlighterInterface : RClass<ReactSyntaxHighlighterProps> {
    fun registerLanguage(language: String, module: dynamic)
}

external val Prism: SyntaxHighlighterInterface
external val PrismLight: SyntaxHighlighterInterface

external val SyntaxHighlighter: SyntaxHighlighterInterface
external val Light: SyntaxHighlighterInterface

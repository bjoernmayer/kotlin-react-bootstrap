@file:JsModule("react-syntax-highlighter")
@file:JsNonModule

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

external val Prism: RClass<ReactSyntaxHighlighterProps>

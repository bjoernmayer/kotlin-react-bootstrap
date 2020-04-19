@file:JsModule("react-router-dom")
@file:JsNonModule

package react.bootstrap.site.external

import react.RProps
import react.router.dom.RouteResultMatch

external fun matchPath(path: String, props: MatchProps): RouteResultMatch<RProps>?

external interface MatchProps : RProps {
    var path: String
    var exact: Boolean
    var strict: Boolean
}

external interface BrowserRouterProps : RProps {
    var basename: String
    var forceRefresh: Boolean
    var getUserConfirmation: dynamic
    var keyLength: Int
}

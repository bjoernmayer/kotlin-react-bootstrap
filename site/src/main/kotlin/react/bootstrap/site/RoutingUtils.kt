package react.bootstrap.site

import react.RProps
import react.bootstrap.site.external.MatchProps
import react.bootstrap.site.external.matchPath
import react.router.dom.RouteResultProps

fun RouteResultProps<RProps>.from(props: RouteResultProps<RProps>) {
    history = props.history
    location = props.location
    match = props.match
}

data class MatchProps(
    override var path: String,
    override var exact: Boolean = false,
    override var strict: Boolean = false
) : MatchProps

fun pathMatches(path: String, props: MatchProps): Boolean =
    matchPath(path, props) !== null

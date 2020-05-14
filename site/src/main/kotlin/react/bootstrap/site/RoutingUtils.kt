package react.bootstrap.site

import react.RProps
import react.bootstrap.site.external.MatchProps
import react.bootstrap.site.external.matchPath
import react.functionalComponent
import react.router.dom.RouteResultProps
import react.router.dom.useLocation
import react.useEffect
import kotlin.browser.window

internal fun <T : RProps> RouteResultProps<T>.from(props: RouteResultProps<T>) {
    history = props.history
    location = props.location
    match = props.match
}

internal data class MatchProps(
    override var path: String,
    override var exact: Boolean = false,
    override var strict: Boolean = false
) : MatchProps

internal fun pathMatches(path: String, props: MatchProps): Boolean =
    matchPath(path, props) !== null

internal val scrollToTop = functionalComponent<RProps> {
    val pathName = useLocation().pathname

    useEffect(listOf(pathName)) {
        window.scrollTo(0.0, 0.0)
    }
}

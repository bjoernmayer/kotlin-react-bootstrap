package react.bootstrap.lib.component

import kotlinext.js.jsObject
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.bootstrap.ClassNames
import react.cloneElement
import react.dom.WithClassName

/**
 * Wraps the [ReactElement] resulting from [block] with the [classNames] set and adds the new element as child.
 */
fun RBuilder.classNameWrapper(
    classNames: Set<ClassNames>,
    block: ElementProvider
): ReactElement {
    val element = RBuilder().block()

    val clone = cloneElement<WithClassName>(
        element,
        jsObject {
            this.className = element.props.unsafeCast<WithClassName>().className.appendClass(classNames)
        }
    )

    return child(clone)
}

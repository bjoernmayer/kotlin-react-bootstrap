@file:Suppress("DuplicatedCode")

package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.accessKey
import kotlinx.html.classes
import kotlinx.html.contentEditable
import kotlinx.html.dir
import kotlinx.html.draggable
import kotlinx.html.hidden
import kotlinx.html.id
import kotlinx.html.lang
import kotlinx.html.spellCheck
import kotlinx.html.tabIndex
import kotlinx.html.title
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import kotlin.reflect.KProperty

fun CommonAttributeGroupFacade.loadGlobalAttributes(props: WithGlobalAttributes, vararg excludes: KProperty<*>) {
    if (props::accesskey !in excludes) {
        props.accesskey?.let { accessKey = it }
    }

    if (props::contenteditable !in excludes) {
        props.contenteditable?.let { contentEditable = it }
    }

    if (props::data !in excludes) {
        props.data?.let {
            it.forEach { (key, value) ->
                data(key, value)
            }
        }
    }

    if (props::dir !in excludes) {
        props.dir?.let { dir = it }
    }

    if (props::draggable !in excludes) {
        props.draggable?.let { draggable = it }
    }

    if (props::hidden !in excludes) {
        props.hidden?.let { hidden = it }
    }

    if (props::id !in excludes) {
        props.id?.let { id = it }
    }

    if (props::lang !in excludes) {
        props.lang?.let { lang = it }
    }

    if (props::spellcheck !in excludes) {
        props.spellcheck?.let { spellCheck = it }
    }

    if (props::tabIndex !in excludes) {
        props.tabIndex?.let { tabIndex = it }
    }

    if (props::title !in excludes) {
        props.title?.let { title = it }
    }

    if (props::translate !in excludes) {
        props.translate?.let { attributes["translate"] = it }
    }

    if (props::classes !in excludes) {
        props.classes?.let { classes = it }
    }
}

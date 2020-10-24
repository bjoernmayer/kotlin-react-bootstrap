package react.bootstrap.lib.rprops

import kotlinx.html.Dir
import kotlinx.html.Draggable
import react.dom.WithClassName

interface WithGlobalAttributes {
    var accesskey: String?
    var contenteditable: Boolean?
    var data: Map<String, String>?
    var dir: Dir?
    var draggable: Draggable?
    var hidden: Boolean?
    var id: String?
    var lang: String?
    var spellcheck: Boolean?
    var style: String?
    var tabIndex: String?
    var title: String?
    var translate: String?
    var classes: Set<String>?
}

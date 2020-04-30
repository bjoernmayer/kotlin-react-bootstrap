package react.bootstrap.content.typography

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.WithClassName
import react.dom.li
import react.dom.ul

enum class ListStyles(val className: ClassNames) {
    UNSTYLED(ClassNames.LIST_UNSTYLED),
    INLINE(ClassNames.LIST_INLINE);
}

fun RBuilder.ul(
    listStyles: ListStyles,
    classes: String? = null,
    block: RDOMBuilder<UL>.() -> Unit
): ReactElement = when (listStyles) {
    ListStyles.UNSTYLED -> child(UnstyledList::class) {
        attrs {
            this.block = block
            this.className = classes
        }
    }
    ListStyles.INLINE -> child(InlineList::class) {
        attrs {
            this.block = block
            this.className = classes
        }
    }
}

class UnstyledList : RComponent<UnstyledList.Props, RState>() {
    interface Props : WithClassName {
        var block: RDOMBuilder<UL>.() -> Unit
    }

    override fun RBuilder.render() {
        ul(classes = props.className.appendClass(ListStyles.UNSTYLED.className)) {
            props.block.invoke(this)
        }
    }
}

class InlineList : RComponent<InlineList.Props, RState>() {
    interface Props : WithClassName {
        var block: RDOMBuilder<UL>.() -> Unit
    }

    override fun RBuilder.render() {
        ul(classes = props.className.appendClass(ListStyles.INLINE.className), block = props.block)
    }
}

enum class ListItemStyles(val className: ClassNames) {
    INLINE(ClassNames.LIST_INLINE);
}

fun RBuilder.li(
    listItemStyles: ListItemStyles,
    classes: String? = null,
    block: RDOMBuilder<LI>.() -> Unit
): ReactElement = when (listItemStyles) {
    ListItemStyles.INLINE -> child(InlineListItem::class) {
        attrs {
            this.className = classes
            this.block = block
        }
    }
}

class InlineListItem : RComponent<InlineListItem.Props, RState>() {
    interface Props : WithClassName {
        var block: RDOMBuilder<LI>.() -> Unit
    }

    override fun RBuilder.render() {
        li(classes = props.className.appendClass(ListItemStyles.INLINE.className), block = props.block)
    }
}

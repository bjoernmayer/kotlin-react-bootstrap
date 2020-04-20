package react.bootstrap.layout.grid

import kotlinx.html.DIV
import kotlinx.html.TagConsumer
import react.*
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

enum class Cols(private val classNames: ClassNames) {
    COL_1(ClassNames.COL_1),
    COL_2(ClassNames.COL_2),
    COL_3(ClassNames.COL_3),
    COL_4(ClassNames.COL_4),
    COL_5(ClassNames.COL_5),
    COL_6(ClassNames.COL_6),
    COL_7(ClassNames.COL_7),
    COL_8(ClassNames.COL_8),
    COL_9(ClassNames.COL_9),
    COL_10(ClassNames.COL_10),
    COL_11(ClassNames.COL_11),
    COL_12(ClassNames.COL_12),
    COL(ClassNames.COL),
    COL_AUTO(ClassNames.COL_AUTO);

    override fun toString(): String {
        return "$classNames"
    }
}

enum class ColsSm(private val classNames: ClassNames) {
    COL_1(ClassNames.COL_SM_1),
    COL_2(ClassNames.COL_SM_2),
    COL_3(ClassNames.COL_SM_3),
    COL_4(ClassNames.COL_SM_4),
    COL_5(ClassNames.COL_SM_5),
    COL_6(ClassNames.COL_SM_6),
    COL_7(ClassNames.COL_SM_7),
    COL_8(ClassNames.COL_SM_8),
    COL_9(ClassNames.COL_SM_9),
    COL_10(ClassNames.COL_SM_10),
    COL_11(ClassNames.COL_SM_11),
    COL_12(ClassNames.COL_SM_12),
    COL(ClassNames.COL_SM),
    COL_AUTO(ClassNames.COL_SM_AUTO);

    override fun toString(): String {
        return "$classNames"
    }
}

enum class ColsMd(private val classNames: ClassNames) {
    COL_1(ClassNames.COL_MD_1),
    COL_2(ClassNames.COL_MD_2),
    COL_3(ClassNames.COL_MD_3),
    COL_4(ClassNames.COL_MD_4),
    COL_5(ClassNames.COL_MD_5),
    COL_6(ClassNames.COL_MD_6),
    COL_7(ClassNames.COL_MD_7),
    COL_8(ClassNames.COL_MD_8),
    COL_9(ClassNames.COL_MD_9),
    COL_10(ClassNames.COL_MD_10),
    COL_11(ClassNames.COL_MD_11),
    COL_12(ClassNames.COL_MD_12),
    COL(ClassNames.COL_MD),
    COL_AUTO(ClassNames.COL_MD_AUTO);

    override fun toString(): String {
        return "$classNames"
    }
}

enum class ColsLg(private val classNames: ClassNames) {
    COL_1(ClassNames.COL_LG_1),
    COL_2(ClassNames.COL_LG_2),
    COL_3(ClassNames.COL_LG_3),
    COL_4(ClassNames.COL_LG_4),
    COL_5(ClassNames.COL_LG_5),
    COL_6(ClassNames.COL_LG_6),
    COL_7(ClassNames.COL_LG_7),
    COL_8(ClassNames.COL_LG_8),
    COL_9(ClassNames.COL_LG_9),
    COL_10(ClassNames.COL_LG_10),
    COL_11(ClassNames.COL_LG_11),
    COL_12(ClassNames.COL_LG_12),
    COL(ClassNames.COL_LG),
    COL_AUTO(ClassNames.COL_LG_AUTO);

    override fun toString(): String {
        return "$classNames"
    }
}

enum class ColsXl(private val classNames: ClassNames) {
    COL_1(ClassNames.COL_XL_1),
    COL_2(ClassNames.COL_XL_2),
    COL_3(ClassNames.COL_XL_3),
    COL_4(ClassNames.COL_XL_4),
    COL_5(ClassNames.COL_XL_5),
    COL_6(ClassNames.COL_XL_6),
    COL_7(ClassNames.COL_XL_7),
    COL_8(ClassNames.COL_XL_8),
    COL_9(ClassNames.COL_XL_9),
    COL_10(ClassNames.COL_XL_10),
    COL_11(ClassNames.COL_XL_11),
    COL_12(ClassNames.COL_XL_12),
    COL(ClassNames.COL_XL),
    COL_AUTO(ClassNames.COL_XL_AUTO);

    override fun toString(): String {
        return "$classNames"
    }
}

class COL(initialAttributes: Map<String, String>, consumer: TagConsumer<*>) : DIV(initialAttributes, consumer)

interface ColProps : RProps {
    var col: Cols?
    var sm: ColsSm?
    var md: ColsMd?
    var lg: ColsLg?
    var xl: ColsXl?
    var classes: String?
    var block: RDOMBuilder<COL>.() -> Unit
}

internal class Col : RComponent<ColProps, RState>() {
    override fun RBuilder.render() {
        val variants = listOfNotNull(props.col, props.sm, props.md, props.lg, props.xl).run {
            if (isEmpty()) {
                listOf(Cols.COL)
            } else {
                this
            }
        }
        val classes = props.classes.appendClass(variants.joinToString(" "))

        col(classes) {
            val block = props.block
            block()
        }
    }

    companion object {
        private fun RBuilder.col(classes: String? = null, block: RDOMBuilder<COL>.() -> Unit): ReactElement =
            @Suppress("UNCHECKED_CAST")
            div(classes, block as RDOMBuilder<DIV>.() -> Unit)
    }
}

fun RBuilder.col(
    col: Cols? = null,
    sm: ColsSm? = null,
    md: ColsMd? = null,
    lg: ColsLg? = null,
    xl: ColsXl? = null,
    classes: String? = null,
    block: RDOMBuilder<COL>.() -> Unit
): ReactElement = child(Col::class) {
    attrs.col = col
    attrs.sm = sm
    attrs.md = md
    attrs.lg = lg
    attrs.xl = xl

    attrs.classes = classes
    attrs.block = block
}

/**
col() -> <div class="col">
col(Cols.COL1) -> div class="col-1">


 */

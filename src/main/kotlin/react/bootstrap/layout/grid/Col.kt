package react.bootstrap.layout.grid

import kotlinx.html.DIV
import kotlinx.html.TagConsumer
import react.*
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

enum class ColVariants(private val classNames: ClassNames) {
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
    COL_SM_1(ClassNames.COL_SM_1),
    COL_SM_2(ClassNames.COL_SM_2),
    COL_SM_3(ClassNames.COL_SM_3),
    COL_SM_4(ClassNames.COL_SM_4),
    COL_SM_5(ClassNames.COL_SM_5),
    COL_SM_6(ClassNames.COL_SM_6),
    COL_SM_7(ClassNames.COL_SM_7),
    COL_SM_8(ClassNames.COL_SM_8),
    COL_SM_9(ClassNames.COL_SM_9),
    COL_SM_10(ClassNames.COL_SM_10),
    COL_SM_11(ClassNames.COL_SM_11),
    COL_SM_12(ClassNames.COL_SM_12),
    COL_MD_1(ClassNames.COL_MD_1),
    COL_MD_2(ClassNames.COL_MD_2),
    COL_MD_3(ClassNames.COL_MD_3),
    COL_MD_4(ClassNames.COL_MD_4),
    COL_MD_5(ClassNames.COL_MD_5),
    COL_MD_6(ClassNames.COL_MD_6),
    COL_MD_7(ClassNames.COL_MD_7),
    COL_MD_8(ClassNames.COL_MD_8),
    COL_MD_9(ClassNames.COL_MD_9),
    COL_MD_10(ClassNames.COL_MD_10),
    COL_MD_11(ClassNames.COL_MD_11),
    COL_MD_12(ClassNames.COL_MD_12),
    COL_LG_1(ClassNames.COL_LG_1),
    COL_LG_2(ClassNames.COL_LG_2),
    COL_LG_3(ClassNames.COL_LG_3),
    COL_LG_4(ClassNames.COL_LG_4),
    COL_LG_5(ClassNames.COL_LG_5),
    COL_LG_6(ClassNames.COL_LG_6),
    COL_LG_7(ClassNames.COL_LG_7),
    COL_LG_8(ClassNames.COL_LG_8),
    COL_LG_9(ClassNames.COL_LG_9),
    COL_LG_10(ClassNames.COL_LG_10),
    COL_LG_11(ClassNames.COL_LG_11),
    COL_LG_12(ClassNames.COL_LG_12),
    COL_XL_1(ClassNames.COL_XL_1),
    COL_XL_2(ClassNames.COL_XL_2),
    COL_XL_3(ClassNames.COL_XL_3),
    COL_XL_4(ClassNames.COL_XL_4),
    COL_XL_5(ClassNames.COL_XL_5),
    COL_XL_6(ClassNames.COL_XL_6),
    COL_XL_7(ClassNames.COL_XL_7),
    COL_XL_8(ClassNames.COL_XL_8),
    COL_XL_9(ClassNames.COL_XL_9),
    COL_XL_10(ClassNames.COL_XL_10),
    COL_XL_11(ClassNames.COL_XL_11),
    COL_XL_12(ClassNames.COL_XL_12),
    COL(ClassNames.COL),
    COL_SM(ClassNames.COL_SM),
    COL_MD(ClassNames.COL_MD),
    COL_LG(ClassNames.COL_LG),
    COL_XL(ClassNames.COL_XL);

    override fun toString(): String {
        return "$classNames"
    }
}

class COL(initialAttributes: Map<String, String>, consumer: TagConsumer<*>) : DIV(initialAttributes, consumer)

interface ColProps : RProps {
    var variants: MutableSet<ColVariants>
    var classes: String?
    var block: RDOMBuilder<COL>.() -> Unit
}

internal class Col : RComponent<ColProps, RState>() {
    override fun RBuilder.render() {
        val classes = props.classes.appendClass(props.variants.joinToString(" "))

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
    variant: ColVariants,
    classes: String? = null,
    block: RDOMBuilder<COL>.() -> Unit
): ReactElement = child(Col::class) {
    attrs.variants = mutableSetOf(variant)

    attrs.classes = classes
    attrs.block = block
}

fun RBuilder.col(
    variants: Set<ColVariants>,
    classes: String? = null,
    block: RDOMBuilder<COL>.() -> Unit
): ReactElement = child(Col::class) {
    attrs.variants = variants.toMutableSet()

    attrs.classes = classes
    attrs.block = block
}
